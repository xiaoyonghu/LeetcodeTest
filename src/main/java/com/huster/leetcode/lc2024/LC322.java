package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/1 11:06
 * @Desc 零钱兑换 DP
 */
public class LC322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

//        int[] coins = {2};
//        int amount = 3;

        // coins = [2], amount = 3
        // -1
        System.out.println(coinChange(coins, amount));
    }

    /**
     * @Author Syong
     * @Description
     **/
    public static int coinChange(int[] coins, int amount) {
        // dp[i]:i值对应的最少得硬币数
        int[] dp = new int[amount + 1];

        // 初始化
        for (int i = 0; i <= amount ; i++) {
            dp[i] = amount + 1;
        }
        // 初始化最开始的一个
        dp[0] = 0;

        // 动态转移方程(类似于走台阶，只不过每种步骤的步数是通过数组来给与的)
        // O(n*m)   O(n)
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }
}
