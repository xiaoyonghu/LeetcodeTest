package com.huster.leetcode.fallHireExam.Bilibili;

/**
 * @author Created by Divo
 * @date 2020/9/4
 * Description:一个有n长度的由1.0组成的字符串，0->1可以替换k次，然后找出替换后的最长子串
 * Status:unfinished
 *      要学会多刷题
 *      这种需要替换多少次的都可以才采用这种模板
 */
public class Exam005 {
    public int GetMaxConsecutiveOnes(int[] arr, int k) {
        int[] max = new int[1];
        dfs(arr, k, 0, max);
        return max[0];
    }

    private void dfs(int[] arr, int k, int step, int[] max) {
        int len = findMaxSubArr(arr);
        if (step > k || (len + k - step) < max[0]) {
            return;
        }
        if (step == k) {
            if (len > max[0]) {
                max[0] = len;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
                dfs(arr, k, step + 1, max);
                arr[i] = 0;
            }
        }
    }

    private int findMaxSubArr(int[] arr) {
        if (arr.length == 0)
            return 0;

        int start = 0;
        int end = 0;
        int maxsize = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                end++;
            } else {
                if (end - start + 1 > maxsize) {
                    maxsize = end - start + 1;
                }
                start = i;
                end = i;
            }
        }
        return maxsize;
    }
}
