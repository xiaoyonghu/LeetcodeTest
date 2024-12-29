package com.huster.leetcode.lc2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/29 19:30
 * @Desc 三角形最小路径和  dp  从下往上
 */
public class LC120 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2, 0, 0, 0));
        triangle.add(Arrays.asList(3, 4, 0, 0));
        triangle.add(Arrays.asList(6, 5, 7, 0));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(triangle));

    }
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int rowNum = triangle.size();
//        int colNum = triangle.get(0).size();
//        // dp方程里面最下面的一列的初始化的值
//        for (int i = rowNum -2; i >=0 ; i--) {
//            for (int j = colNum; j >=0; j--) {
//                // dp状态转移方程
//                // dp[i][j] = triangle[i][j] + min(dp[i-1][j],dp[i-1][j-1])
//                // 这里支持不了这种写法
//                triangle.get(i).get(j) = triangle.get(i).get(j) +
//                        Math.min(triangle.get(i-1).get(j),triangle.get(i-1).get(j+1));
//            }
//        }
//        return triangle.get(0).get(0);
//    }


    // 这个sb题目，心累
    // 抛弃这个题
    public static int minimumTotal(List<List<Integer>> triangle) {
        int rowNum = triangle.size();
        int colNum = triangle.get(rowNum-1).size();
//        int[] dp = new int[colNum];
        int[][] dp = new int[rowNum][colNum];
        for (int i = 0; i < colNum; i++) {
            dp[rowNum-1][i] = triangle.get(rowNum - 1).get(i);
        }
        // dp方程里面最下面的一列的初始化的值
        for (int i = rowNum - 2; i >= 0; i--) {
            for (int j = colNum - 1; j >=0 ; j--) {
                // dp状态转移方程
                // dp[i][j] = triangle[i][j] + min(dp[i-1][j],dp[i-1][j-1])
//                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j],dp[i-1][j-1]);
            }
        }
        return dp[0][0];
    }
}
