package com.huster.leetcode.fallHireExam.tencent;


import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/12
 * Description: 面试题  最少能休息多少天？锻炼和工作不能2天连续在一起
 * 1 1 0 0 0
 * 0 1 1 0 0
 * dp三维？？？ 难道还是可以直接用list存上一个选择的类型？？
 * Status:new
 */
public class test003 {

    public static int getMinDaysToRest(int[] work, int[] exercise, int n) {
        //int res = 0 ;
        int[][][] dp = new int[n + 1][2][2];
        dp[0][0][0] = 0;

        for (int i = 1; i < n; i++) {
            int a = work[i - 1];
            int b = exercise[i - 1];
//            dp[0][0][0]
//            dp[0][0][1]
//            dp[0][1][0]
            if (a == 1) {
                dp[i][1][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1]) + 1;
            }
            if (b == 1) {
                dp[i][0][1] = Math.max(dp[i - 1][0][0], dp[i - 1][1][0]) + 1;
            }
//            if () {
//
//            }
        }


        return 0;
    }

}
