package com.huster.leetcode.fallHireExam.meiTuan;

/**
 * @author Created by Divo
 * @date 2020/9/22
 * Description: lc 54 以AC
 * Status:new
 */
public class test {

    public static boolean canJump(int[] nums) {
        int len = nums.length;
        int[] rev = new int[len];
        for (int i = 0, j = len - 1; i < len; i++, j--) {
            rev[j] = nums[i];
        }
        //rev[0] = 0 ;
        int i;
        int k;
        int start = 0;
        for (i = 0; i < len - 1; ) {
            for (k = i + 1; k < len; k++) {
                if ((rev[k]) >= (k - i)) {
                    start = k;
                    break;
                }
                if (k != (len - 1)) {
                    continue;
                } else {
                    return false;
                }
            }
            i = start;
        }
        return true;

    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        int[] arr = {2, 0, 0};
        System.out.println(canJump(arr));
    }
}
