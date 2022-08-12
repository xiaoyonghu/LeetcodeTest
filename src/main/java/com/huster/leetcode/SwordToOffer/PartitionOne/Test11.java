package com.huster.leetcode.SwordToOffer.PartitionOne;

/**
 * @author Created by Divo
 * @date 2022/8/11
 * Description: 旋转数组的最小数字
 * Status:new
 */
public class Test11 {
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1, m;
        while (l != r) {
            m = (l + r) >> 1;
            if (numbers[m] > numbers[r]) {
                l = m + 1;
            } else if (numbers[m] < numbers[r]) {
                r = m;
            } else {
                r--;
            }
        }
        return numbers[l];
    }

    public static void main(String[] args) {
//        int[] array = {3, 4, 5, 1, 2};
        int[] array = {2,2,2,0,1};
        Test11 test11 = new Test11();
        System.out.println(test11.minArray(array));
    }
}
