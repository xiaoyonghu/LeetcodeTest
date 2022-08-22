package com.huster.leetcode.SwordToOffer.PartitionOne;

/**
 * @author Yongshao
 * @Date 2022/8/16
 * Description: 剪绳子_2 : 和1一模一样
 */
public class Test14_2 {

    // 未考虑到可能会超出数组
//    public int cuttingRope(int n) {
//        if (n <= 3) return n - 1;
//        int a = n / 3, b = n % 3;
//        if (b == 0) {
//            return (int) Math.pow(3, a) % 1000000007;
//        } else if (b == 1) {
//            return (int) (Math.pow(3, a - 1) * 4) % 1000000007;
//        } else {
//            return (int) (Math.pow(3, a) * 2) % 1000000007;
//        }
//    }

    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }

    public static void main(String[] args) {

    }

}
