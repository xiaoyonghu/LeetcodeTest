package com.huster.leetcode.SwordToOffer.PartitionOne;

import java.util.Map;

/**
 * @author Yongshao
 * @Date 2022/8/15
 * Description: 剪绳子
 * 数学不好，我很抱歉
 */
public class Test14 {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        } else if (b == 1) {
            return (int) (Math.pow(3, a - 1) * 4);
        } else {
            return (int) (Math.pow(3, a) * 2);
        }
    }

    public static void main(String[] args) {

    }
}
