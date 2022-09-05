package com.huster.leetcode.SwordToOffer.PartitionFour;

/**
 * @author Created by Divo
 * @date 2020/4/11
 * Description:礼物的最大值，给坐标和礼物
 * Status:dp
 */
public class test47 {

    // 一个元素的值 从左边、上面
    // 因为是至于上面和下面的值强相关，所以不需要重新新建dp数组
    // dp[i]=Max(dp[i-1，j],dp[i,j-1]) + gift[i,j]

    public int maxValue(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        if (row == 0 || col == 0) {
            return -1;
        }

        for (int i = 1; i < col; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int j = 1; j < row; j++) {
            grid[j][0] += grid[j - 1][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                //            上面          左边
                grid[i][j] = Math.max(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[row - 1][col - 1];
    }
}
