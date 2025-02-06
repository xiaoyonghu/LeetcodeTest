package com.huster.leetcode.lc2024;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/25 21:09
 * @Desc 移动零
 * @Type 双指针
 */
public class LC283 {
    public static void main(String[] args) {
//        int[] nums = new int[]{0, 1, 0, 3, 12};
        int[] nums = new int[]{2, 1};
        // [1,3,12,0,0]

        // 1 0 0 3 12
        // 1 3 0 0 12
        // 1 3 12 0 0

        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]+ " ");
        }
    }

    /**
     * @Description using queue
     **/
    public static void moveZeroesUsingQueue(int[] nums) {
        //1、使用队列或者栈 TimeConsume O(N) SpaceConsume O(N)
        Queue<Integer> que = new ArrayDeque<>();
        int len = nums.length;
        int addSize = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                que.add(nums[i]);
                addSize++;
            }
        }

        for (int i = 0; i < len; i++) {
            if (i >= addSize) {
                nums[i] = 0;
            } else {
                nums[i] = que.poll();
            }
        }
    }
    /**
     * @Description 使用双指针（写的不行）
     **/
    public static void moveZeroesDoublePoint(int[] nums) {
        // int[] nums = new int[]{0, 1, 0, 3, 12};
        // 1 0 0 3 12
        // 1 3 0 0 12 0 0 0
        // 1 3 12 0 0
        int len = nums.length;
        if (len == 1) return;
        int l = len;
        for (int i = 0; i < len; i++) { // l表示第一个0下标
            if (nums[i] == 0) {
                l = i;
                break;
            }
        }
        int r = l + 1;
        while (r < len) {   // r表示第一个非0下标
            if (nums[r] != 0) break;
            r++;
        }

        while (r < len) {
            if (nums[l] == 0 && nums[r] != 0) {
                swapValue(l, r, nums);
                l++;
                while (r < len && nums[r] == 0) r++;
            }
        }

    }

    // 最漂亮的写法
    public static void moveZeroes(int[] nums) {
        // int[] nums = new int[]{0, 1, 0, 3, 12};
        // 1 0 0 3 12
        // 1 3 0 0 12 0 0 0
        // 1 3 12 0 0
        int len = nums.length;
        for (int l = 0, r = 0; r < len; r++) {
            if (nums[r] != 0) {
                swapValue(l, r, nums);
                l++;
            }
        }
    }

    public static void swapValue(int i,int j,int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
