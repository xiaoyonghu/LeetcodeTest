package com.huster.leetcode.fallHireExam.youZan;

/**
 * @author Created by Divo
 * @date 2020/9/11
 * Description:
 * Status:new
 */
public class youZan001 {
    public static long sum(int num, int itemNum) {
        long res = 0;
        int K = 1;
        for (int i = itemNum; i > 0; i--) {
            res += (num * i * K);
            K = K * 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sum(3, 5));
    }
}
