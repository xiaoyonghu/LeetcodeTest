package com.huster.leetcode.lc2024;

import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/2/5 22:11
 * @Desc 轮转数组
 */
public class LC189 {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        LC189 lc189 = new LC189();
        int k = 3;
        lc189.rotate(nums, k);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " -> ");
        }
    }

    /**
     * 思路：1、使用一个新的数组
     * @Description 使用一个额外的数组
     **/
    public void rotate(int[] nums, int k) {
        // 怎么和排序的冒泡很像？
        int len = nums.length;
        if (len == 0 || len ==1) return;
        int realK = k % len;
        // 1、使用新的array
        int[] replacedNums = new int[len];
        for (int i = 0; i < realK; i++) {
            replacedNums[i] = nums[len - realK + i];
        }
        for (int i = realK; i < len; i++) {
            replacedNums[i] = nums[i - realK];
        }

        //替换用replaced替换nums
        for (int i = 0; i < len; i++) {
            nums[i] = replacedNums[i];
        }
    }

}
