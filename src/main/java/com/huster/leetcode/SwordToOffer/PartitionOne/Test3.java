package com.huster.leetcode.SwordToOffer.PartitionOne;

/**
 * @author Created by Divo
 * @date 2019/8/19
 * Description:找出数组中重复的数字  剑指Offer
 * Status:finished
 * 时间复杂度 O(n)  空间复杂度O（1）
 * <p>
 * Note:未考虑特殊用例
 */
public class Test3 {
    public boolean duplication(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0)
            return false;
        for (int i = 0; i < length; i++) {
            //先判断i下标的数值与其对于的值是否相等，如果是，那就pass
            while (nums[i] != i) {
                //再判断下标i对应的值与以下标为nums[i]对应的值就行比较，如果是就证明i与nums[i]对应的相等，即存在重复
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                //如果不等，就把i和nums[i]对应的值就行交换
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    public void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] data1 = {2, 3, 1, 0, 2, 5, 3};
        int[] result = new int[1];
        Test3 test3 = new Test3();
        test3.duplication(data1, data1.length, result);
        System.out.println(result[0]);
    }
}
