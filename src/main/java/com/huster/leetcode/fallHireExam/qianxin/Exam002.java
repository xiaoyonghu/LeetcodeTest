package com.huster.leetcode.fallHireExam.qianxin;

/**
 * @author Created by Divo
 * @date 2020/9/2
 * Description: 分房子
 * Status:finished
 */
public class Exam002 {
    public static int numWays(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] arr = new int[nums.length];
        int res = 1;
        arr[0] = 1;
        int start = 0;
        int min = Integer.MAX_VALUE;
        //规则只考虑了后面和前面的
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                arr[i] = arr[i - 1] + 1;

            } else if (nums[i] == nums[i - 1]) {
                arr[i] = 1;

                if (min < 1) {
                    res += (1 - min) * (i - start);
                }
                //更新状态
                min = Integer.MAX_VALUE;
                start = i;
            } else {
                arr[i] = arr[i - 1] - 1;
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            res += arr[i];
        }
        if (min < 1) {
            res += (1 - min) * (nums.length - start);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] in = {3, 2, 4};
        System.out.println(numWays(in));
    }
}
