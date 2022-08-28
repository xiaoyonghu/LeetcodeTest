package com.huster.leetcode.Leetcode;

/**
 * @author Created by Divo
 * @date 2020/8/3
 * Description: Exam94 152乘积最大子数组
 * Thought：典型的DP
 * Status:new
 */
public class Exam152 {
    //DP
//    public int maxProduct(int[] nums) {
//        if (nums.length == 0 || nums == null)
//            return 0;
//        //1、定义DP状态
//        //dp[i][0] 表示使用第i个节点后最大值。dp[i][1] 表示使用第i个节点后最小值。
//        int[][] dp=new int[2][2];
//        int max;
//        dp[0][0]=nums[0];
//        dp[0][1]=nums[0];
//        max=nums[0];
//
//        for (int i = 1; i < nums.length ; i++) {
//            int x=i%2;
//            int y=(i-1)%2;
//            //2、状态转换方程
//            dp[x][0] = Math.max(Math.max(dp[y][0]*nums[i],dp[y][1]*nums[i]),nums[i]);
//            dp[x][1] = Math.min(Math.min(dp[y][0]*nums[i],dp[y][1]*nums[i]),nums[i]);
//            max = dp[x][0]> max? dp[x][0]:max;
//        }
//        return max;
//    }

    //使用简化
    public int maxProduct(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;
        int curMax = nums[0];
        int curMin = nums[0];
        int r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(nums[i], curMax * nums[i]);
            curMin = Math.min(nums[i], curMin * nums[i]);
            r = Math.max(curMax, r);
        }
        return r;
    }
}
