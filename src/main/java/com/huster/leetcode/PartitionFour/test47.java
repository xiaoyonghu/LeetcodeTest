package com.huster.leetcode.PartitionFour;

/**
 * @author Created by Divo
 * @date 2020/4/11
 * Description:礼物的最大值，给坐标和礼物
 * Status:dp
 */
public class test47 {
    //分析，列出动态转移方程式
    //f[i]=Max(F[i-1，j],F[i,j-1])+gift[i,j]

    //只懂了第一种解法

    //1、当i=0,j=0为起始元素
    //2、第一行 只能有一种解法，就是从最左边过来
    //3、第一列 只能有一种解法，就是从最左边过来
    //4、剩下的元素，既可以从左边下来，也可以从右边下来

    public int getGiftMax(int[][] grid){
        //改动数组
        int row=grid.length;
        int col=grid[0].length;
        //先改第一行
        for (int j = 1; j < col; j++) {
            grid[0][j]+=grid[0][j-1];
        }
        //改第一列
        for (int i = 1; i < row; i++) {
            grid[i][0]+=grid[i-1][0];
        }
        for (int i = 1; i < row ; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j]+=Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[row-1][col-1];
    }
}
