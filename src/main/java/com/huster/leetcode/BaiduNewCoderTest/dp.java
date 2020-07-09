package com.huster.leetcode.BaiduNewCoderTest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/3/29
 * Description:动态规划，对于<  >  n个数
 * Status:new
 */
@SpringBootApplication
public class dp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] dp = new int[n + 1][k + 1];
            for (int i = 0; i <= n; i++) dp[i][0] = 1;
            for (int i = 2; i < n + 1; i++) {
                for (int j = 1; j <= k && j < i; j++) {
                    if (j == i - 1) dp[i][j] = 1;
                    else if (i > j - 1) {
                        dp[i][j] = (dp[i - 1][j - 1] * (i - j) + dp[i - 1][j] * (j + 1)) % 2017;
                    }
                }
            }
            System.out.println(dp[n][k]);
        }

    }
}
