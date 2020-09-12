package com.huster.leetcode.fallHireExam.tencent;

/**
 * @author Created by Divo
 * @date 2020/9/11
 * Description:tencent面试，AC
 * Status:finished
 */
public class test001 {
    public long getSum(int n, int m) {
        long size = n / (2 * m);
        long sum = m * m;
        long res = size * sum;
        return res;
    }

    public static void main(String[] args) {

    }
}
