package com.huster.leetcode.Leetcode;

/**
 * @author Created by Divo
 * @date 2020/8/3
 * Description:Exam94 322 零钱兑换  类似爬台阶，只不过有一个条件判断而已
 * Thought：
 * 1、暴力
 * 2、优化的贪心
 * 3、dp
 * Status:finished
 */
public class Exam322 {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0 || coins == null)
            return 0;
        int[] dp = new int[amount + 1];
        //即使有1枚币值大小的在里面，也需要amount枚。
        for (int i = 0; i <= amount; i++) {
            dp[i] = amount + 1;
        }
        //1、定义状态
        // dp[i] i阶台阶最少的步数
        dp[0] = 0;
        //时间复杂度 O（N*K） 空间复杂度0（N）
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    //2 状态方程的转换
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
