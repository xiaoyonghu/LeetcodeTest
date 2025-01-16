package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/16 20:17
 * @Desc 最大子数组和
 * 规则：最大和的"连续"子数组
 */
public class LC053 {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {1};
        LC053 lc053 = new LC053();
        System.out.println(lc053.maxSubArray(nums));
        // Solution-One、2层for循环
        //
    }


    // DP O(N)
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int resMax = Integer.MIN_VALUE;

        // dp[i] 表示算上nums[i]后的最大值
        for (int i = 1; i < len; i++) {
            // 动态转移方程
            // 如果前面一个的总和dp[i-1]<0,直接丢弃 nums[i] = nums[i]；
            // 不然就用前面的一个加上当前的值 nums[i] += nums[i - 1]
            if (nums[i - 1] >= 0) nums[i] += nums[i - 1];
        }

        // 最大值
        for (int i = 0; i < len; i++) {
            resMax = Math.max(resMax, nums[i]);
        }
        return resMax;
    }


    // 2层for TimeConsume: O(N*2)
    // lc 不能过所有的case
    public int maxSubArrayViolence(int[] nums) {
        int len = nums.length;
        int resMax = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            int innerMax = Integer.MIN_VALUE;

            for (int j = i; j < len; j++) {
                sum += nums[j];
                innerMax = Math.max(innerMax, sum);
            }

            resMax = Math.max(resMax, innerMax);
        }
        return resMax;
    }
}
