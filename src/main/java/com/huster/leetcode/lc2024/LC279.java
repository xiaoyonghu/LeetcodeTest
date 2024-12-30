package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/29 23:06
 * @Desc 完全平方数
 */
public class LC279 {
    public static void main(String[] args) {
        // 13
        // 2 = (4 + 9)
        System.out.println(numSquares(13));
    }

    // 暂时没思路
    // 得多刷题，才有思路
    public static int numSquares(int n) {
        // Thought:
        //      1、使用递归
        //      2、使用dp
        // dp[i]表示该数字对应的最少得完全平方数的个数
        int[] dp = new int[n + 1];
        // 初始化
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i ; j++) { // 遍历每个平方数
                // 动态方程转移（由于计算i的时候，前面全部都已经计算好了）
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
            }
        }
        return dp[n];
    }
}
