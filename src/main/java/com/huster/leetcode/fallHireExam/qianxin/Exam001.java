package com.huster.leetcode.fallHireExam.qianxin;

/**
 * @author Created by Divo
 * @date 2020/9/2
 * Description: 青蛙跳
 * Status:finished
 */
public class Exam001 {
    public int numWays(int n) {
        if (n < 0)
            return 0;
        if(n == 0)
            return 1;
        //f(n)= f(n-1)+f(n-2)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%1000000007;
        }
        return dp[n];
    }
}
