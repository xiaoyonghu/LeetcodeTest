package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/30 23:09
 * @Desc 最长递增子序列(严格递增，子序列可以其中的一部分) DP
 */
public class LC300 {
    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums));
        // 4
    }

    public static int lengthOfLIS(int[] nums) {
        // 初始化dp
        // 定义dp[i] 以i元素为最长递增子序列的个数（必须得用上）
        int len = nums.length;
        int[] dp = new int[len];
        // [4,10,4,3,8,9]
        // 赋值
        for (int i = 0; i < len; i++) {
            dp[i] = 1; // 默认都已自己为一个元素
        }

        // TimeConsume = O(N*2)   SpaceConsume = O(N)
        // 动态方程装换，往前面一直找，找到比他小的所有的
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 这里因为不是累加的，所以最大值不确定在哪个数组，需要遍历整个数组
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
