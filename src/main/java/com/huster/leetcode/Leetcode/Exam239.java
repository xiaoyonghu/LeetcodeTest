package com.huster.leetcode.Leetcode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/7/24
 * Description: 滑动窗口的问题
 * solution：1、使用最大堆 O（nlongn）
 * 2、使用一点技巧 O(n)
 * Status:finished
 * level：hard
 */
public class Exam239 {
    int[] result;
    ArrayDeque<Integer> deq = new ArrayDeque<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0)
            return new int[0];
        if (k == 1)
            return nums;
        result = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            //we only pop out one out of range element in one round at most
            // remove numbers out of range k
            if (!deq.isEmpty() && deq.getFirst() <= (i - k)) {
                deq.removeFirst();
            }
            // remove smaller numbers in k range as they are useless
            while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
                deq.removeLast();
            }
            //deq contains index... result contains content
            deq.addLast(i);
            if (i >= k - 1)  //判断滑动窗口是否已经有K个了
                result[i - k + 1] = nums[deq.getFirst()];
        }
        return result;
    }


    public static void main(String[] args) {
        Exam239 exam239 = new Exam239();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(sc.next());
        }
        int[] result = exam239.maxSlidingWindow(arr, k);
        for (int i = 0; i < t - k + 1; i++) {
            System.out.print(result[i] + " --->");
        }
    }
}

