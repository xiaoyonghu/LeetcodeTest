package com.huster.leetcode.SwordToOffer.PartitionFive;

import java.util.ArrayDeque;

/**
 * @author Yongshao
 * @Date 2022/8/22
 * Description: 滑动窗口的最大值
 */
public class Test59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1) return nums;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!deq.isEmpty() && deq.getFirst() <= (i - k)) {
                deq.removeFirst(); //最大值对应的索引已超出K的最左边范围
            }
            while (!deq.isEmpty() && nums[deq.getLast()] < nums[i]) {
                deq.removeLast();  //k个保持单调递减
            }
            deq.addLast(i); //加入值的索引
            if (i >= k - 1) {
                res[i - k + 1] = nums[deq.getFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
