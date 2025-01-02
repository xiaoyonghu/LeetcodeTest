package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/2 21:25
 * @Desc 最小路径和
 */
public class LC064 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

//        int[][] grid = {
//                {1, 2, 3},
//                {4, 5, 6},
//        };

        System.out.println(minPathSum(grid));
    }

    // TimeConsume :O(M*N)  SpaceConsume:O(M*N)
    // Is there any choice to reuse grid,so we don't need SpaceConsume
    public static int minPathSum(int[][] grid) {
        // 典型的dp,，从下往上
        // 规则说明：每次只能向下或者向右移动一步
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j]算上grid[i][j]元素后做小的总数和
        int[][] dp = new int[m][n];

        // 初始化
        // 填充最后一行的数据
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = dp[m - 1][i + 1] + grid[m - 1][i];
        }
        // 填充最后一列
        for (int j = m - 2; j >= 0; j--) {
            dp[j][n - 1] = dp[j + 1][n - 1] + grid[j][n - 1];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                // 动态转移方程
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }

    // TODO:
    // TimeConsume :O(M*N)
    public static int minPathSumNotUsingSpace(int[][] grid) {
        // 典型的dp,，从下往上
        // 规则说明：每次只能向下或者向右移动一步
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j]算上grid[i][j]元素后做小的总数和
        int[][] dp = new int[m][n];

        // 初始化
        // 填充最后一行的数据
        dp[m - 1][n - 1] = grid[m - 1][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = dp[m - 1][i + 1] + grid[m - 1][i];
        }
        // 填充最后一列
        for (int j = m - 2; j >= 0; j--) {
            dp[j][n - 1] = dp[j + 1][n - 1] + grid[j][n - 1];
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                // 动态转移方程
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }
}
