package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/5 20:28
 * @Desc Pow(x, n) 递归 (用来练习递归)
 */
public class LC050 {
    public static void main(String[] args) {
        // x = 2.00000, n = 10

        // x = 2.10000, n = 3
//        double x = 2.00000;
        int n = 10;
        int m = -2;
        double x = 1.0;
        int k = -2147483648;
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(myPow(x, k));
    }

    //Integer.MAX_VALUE =  2147483647
    // 建议使用模板
    public static double myPowNotUsable(double x, int n) {

        // 处理负数
        if (n == 0) return 1.0;
        if (n < 0) {
//            x = 1/x;
//            n = Math.abs(n);
            return 1.0 / myPowNotUsable(x, -n);
        }
        if (x == 1.0) return 1.0;
        if (n == 1) return x;
        if (n % 2 == 1) {
            return x * myPowNotUsable(x * x, n / 2);
        }
        return myPowNotUsable(x * x, n / 2);
    }


    public static double myPow(double x, int n) {
        //Tips: 这里转换为Long类型(为了过测试case)
        long N = n;
        if (n < 0) {
            return 1.0 / quickMul(x, -N);
        }
        return quickMul(x, N);
    }


    public static double quickMul(double x, long n) {
        if (n == 0) return 1.0;
        // n减半
        double y = quickMul(x, n / 2);
        if (n % 2 == 1) {
            return y * y * x;
        }
        return y * y;
    }

}
