package com.huster.leetcode.Leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Created by Divo
 * @date 2020/8/3
 * Description:Exam94 72 编辑距离
 * Thought：采用dp来解决
 * Status:finished
 */
public class Exam72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //1、状态变量的定义
        // dp[i][j] 表示从word1的前i个字符转换为 word2的前j个字符的最少步数
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        //初始化第一行
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        //初始化第一列
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //2、状态转移方程
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //insert   //delete    //replace
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
