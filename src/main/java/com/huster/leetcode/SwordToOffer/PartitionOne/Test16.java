package com.huster.leetcode.SwordToOffer.PartitionOne;

/**
 * @author Yongshao
 * @Date 2022/8/17
 * Description: 数值的整数次方
 *    int-->long
 */
public class Test16 {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        double count = 1, base = x;
        long k = n;
        if (k < 0) {
            base = (1 / x);
            k = (-k);
        }
        while (k > 0) {
            if ((k & 1) != 0) {
                count *= base;
            }
            base *= base;
            k >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
