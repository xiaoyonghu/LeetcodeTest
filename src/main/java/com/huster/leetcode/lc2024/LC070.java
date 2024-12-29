package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/29 18:47
 * @Desc 爬楼梯 动态规划 （递归+内存）
 */
public class LC070 {

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
    public static int climbStairs(int n) {
        // 使用最常规的写法即可
        // Step 1、dp 定义
        // Step 2、dp 初始化
        // Step 3、dp方程
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] +dp[i-2];
        }
        return dp[n];
    }
}
