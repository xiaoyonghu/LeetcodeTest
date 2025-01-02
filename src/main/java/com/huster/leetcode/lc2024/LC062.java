package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/2 20:56
 * @Desc 不同路径 典型的动态方程（从下往上）
 */
public class LC062 {
    public static void main(String[] args) {
//        int m = 3, n = 7;
        int m = 3, n = 2;
        // res = 28
        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        // 规则：机器人每次只能向下或者向右移动一步
        // 非常典型的倒推，从下往上
        // dp[i][j] 表示能到达[i][j]总共有多少种走法
        int[][] dp = new int[m][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = 1;
        }
        for (int j = 0; j < m; j++) {
            dp[j][n - 1] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        return dp[0][0];
    }
}
