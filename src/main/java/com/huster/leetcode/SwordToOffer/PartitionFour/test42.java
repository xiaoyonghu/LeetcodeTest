package com.huster.leetcode.SwordToOffer.PartitionFour;

/**
 * @author Yongshao
 * @Date 2022/8/28
 * Description:连续子数组的最大和
 */
public class test42 {

    // 使用DP来实现
    public int maxSubArray(int[] nums) {
        if (nums == null) return -1;
        int len = nums.length, max;
        int[] dp = new int[len];
        // dp中的值为包括num[i]后的最大值
        dp[0] = max = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = max > dp[i] ? max : dp[i];
        }

        return max;
    }

    public static void main(String[] args) {

    }
}
