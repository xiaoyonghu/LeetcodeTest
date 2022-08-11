package com.huster.leetcode.SwordToOffer.PartitionOne;

/**
 * @author Created by Divo
 * @date 2022/8/10
 * Description:斐波拉契数列
 * 1、从上往下
 * 会有一些重复的计算
 * 2、从下往上
 * dp的标准形式（有时候可以使用变量来代替dp数组，实现O（1）的空间复杂度）
 * Status:new
 */
public class Test10 {
    //额外的O（N)空间
//    public int fib(int n) {
//        if (n == 0 || n == 1) return n;
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//            dp[i] = dp[i] % 1000000007;
//        }
//        return dp[n];
//    }

    //使用变量进行O（1）
    //注意，这里不是；累加
    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int k = 0; k < n; k++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        Test10 test10 = new Test10();
        System.out.println(test10.fib(5));
    }

}
