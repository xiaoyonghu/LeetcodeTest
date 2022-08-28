package com.huster.leetcode.Leetcode;

/**
 * @author Created by Divo
 * @date 2020/8/5
 * Description:Exam94 198 打家劫舍I
 * DP思想
 * Status:finished
 */
public class Exam198 {
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        //一个位置只有2种选择，抢，不抢（选择其中较大的）
        //dp[i] 从第i家抢能得到的最大值
        int n = nums.length;
        int[] dp = new int[n + 2];

        for (int i = n - 1; i >= 0; i--) {
            //不抢   抢
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        //int dp_1 =0, dp_2=0;
        return dp[0];
    }

    public int rob1(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        int n = nums.length;
        int dp_1 = 0, dp_2 = 0, dpMax = 0;
        for (int i = n - 1; i >= 0; i--) {
            //不抢   抢
            dpMax = Math.max(dp_1, nums[i] + dp_2);
            dp_2 = dp_1;
            dp_1 = dpMax;
        }
        return dpMax;
    }
}
