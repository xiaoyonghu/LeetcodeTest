package com.huster.leetcode.lc2024;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/29 22:01
 * @Desc 杨辉三角 DP(可以称为dp，也可以不称为dp)
 */
public class LC118 {
    public static void main(String[] args) {
        int  num = 5;
        List<List<Integer>> generate = generate(num);
        // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resList = new ArrayList<>();
        int[][] dp = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                list.add(dp[i][j]);
            }
            resList.add(list);
        }

        return resList;
    }
}
