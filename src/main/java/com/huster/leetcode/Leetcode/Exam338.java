package com.huster.leetcode.Leetcode;

/**
 * @author Created by Divo
 * @date 2020/8/4
 * Description:Exam94 338 比特位数
 * Status:finished
 */
public class Exam338 {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for (int i = 0; i <= num; i++) {
            result[i] = 0;
        }

        //讨论区的人才是真的多
        for (int i = 1; i <= num; i++) {
         //   result[i] = result[i&(i-1)] + 1; //result[i&(i-1)]必定在result[i]之前就已经算出来
            result[i] = result[i>>1] + (i&1);
        }
        return result;
    }
}
