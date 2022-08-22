package com.huster.leetcode.SwordToOffer.PartitionTwo;

/**
 * @author Yongshao
 * @Date 2022/8/22
 * Description: 一个数组使奇数位于偶数前面
 * 双指正问题
 */
public class Test21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 1) return nums;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            while ((nums[l] & 1) != 0) {
                l++; //l指向做左边的一个偶数
                if (l == r) break;
            }
            while ((nums[r] & 1) == 0) {
                r--;
                if (l == r) break;
            }
            if (l <= r) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }
        return nums;
    }

    static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {

    }
}
