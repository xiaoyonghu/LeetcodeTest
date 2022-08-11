package com.huster.leetcode.SwordToOffer.PartitionOne;

/**
 * @author Created by Divo
 * @date 2022/8/11
 * Description:青蛙跳台阶
 * 找规律
 */
public class Test10_2 {
//    public int numWays(int n) {
//        if (n < 0) {
//            return 0;
//        }
//        if (n == 0) {
//            return 1;
//        }
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
//        }
//        return dp[n];
//    }

    //不使用dp数组，变量强相关，最简化
    public int numWays(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int a = 1, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        Test10_2 test10_2 = new Test10_2();
        System.out.println(test10_2.numWays(7));
    }
}
