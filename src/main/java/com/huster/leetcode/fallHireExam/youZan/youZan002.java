package com.huster.leetcode.fallHireExam.youZan;

import java.util.Arrays;

/**
 * @author Created by Divo
 * @date 2020/9/11
 * Description:把数值变为相同需要的做少步数
 * Status:new
 */
public class youZan002 {
    public static int minMoves (int[] nums) {
        int res=0;
        int[] arr = nums;
        Arrays.sort(arr);
        //暴力求所有，不行的话
        int len = arr.length;
        if (len  == 1)
            return arr[0];
        int mid = len/2;
        int midValue = arr[mid];
        for (int i = 0; i < len; i++) {
             res += Math.abs(arr[i] - midValue);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {1,2,4};
        System.out.println(minMoves(test));

    }
}
