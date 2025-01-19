package com.huster.leetcode.Niuke;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/19 15:32
 * @Desc DP41 0-1背包问题
 * lc 该题需要plus会员
 */
public class DP41 {
    public static void main(String[] args) {
        int[] wts = {2, 4, 1};
        int[] vals = {10, 5, 4};
        int N = 3;
        int W = 5;
        DP41 dp41 = new DP41();
        System.out.println(dp41.knapsack(W, N, wts, vals));
    }
    /**
     * 非常经典的选择性问题
     */
    int knapsack(int W, int N, int[] wt, int[] val) {
        // 1、dp定义
        // dp[i][w]表示在前i个[0,i]物品下，背包容量为w的情况下，能装的最大价值（w体积不一定满了）
        int[][] dp = new int[N + 1][W + 1];

        // 2、初始化
        // dp[0][...] dp[...][0] 表示在没有物品或背包没有体积的情况下的最大价值都为0

        // 3、动态转移方程
        // i表示i-1，表示从第一个开始计数
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                // 背包装不下了
                if (w - wt[i-1] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w]= Math.max(dp[i - 1][w], dp[i-1][w-wt[i-1]] + val[i-1]);
                }
            }
        }

        return dp[N][W];
    }

}
