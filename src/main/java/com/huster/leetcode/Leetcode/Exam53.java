package com.huster.leetcode.Leetcode;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/7/25
 * Description: 最大
 * Status:new
 */
public class Exam53 {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        int max=nums[0];
        for (int i = 1; i < len; i++) {
            // DP[i] 到达i节点时的最大和的连续子序列

            //转换方程 dp[i] = max{dp[i-1]+ nums[i],nums[i]}
            //是自己为一段还是和前面的组成一段
            nums[i] = Math.max(nums[i-1]+nums[i],nums[i]);
            if (nums[i] > max)
                max = nums[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(sc.next());
        }
        Exam53 exam53 = new Exam53();
        System.out.println(exam53.maxSubArray(arr));
    }
}
