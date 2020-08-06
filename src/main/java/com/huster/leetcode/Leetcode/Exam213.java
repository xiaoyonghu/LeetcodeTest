package com.huster.leetcode.Leetcode;

/**
 * @author Created by Divo
 * @date 2020/8/5
 * Description:lc 213 打家劫舍II
 * Status:finished
 */
public class Exam213 {

    public int rob(int[] nums) {
        if (nums.length == 0 || nums==null)
            return 0;
        if (nums.length == 1)
            return nums[0];
       return Math.max(dp(nums,0,nums.length-2),dp(nums,1,nums.length-1));
    }

    public int dp(int[] nums,int start,int end) {
        int dp_1 = 0, dp_2 = 0,dpMax = 0;
        for (int i = end; i >=start; i--) {
            //不抢   抢
            dpMax = Math.max(dp_1,nums[i]+dp_2);
            dp_2 = dp_1;
            dp_1 = dpMax;
        }
        return dpMax;
    }
}
