package com.huster.leetcode.SwordToOffer.PartitionOne;

/**
 * @author Yongshao
 * @Date 2022/8/17
 * Description: 二进制中1的个数
 */
public class Test15 {

    //第一种，使用 & 上每一位，然后计数
//    public int hammingWeight(int n) {
//        int mask = 1, count = 0;
//        for (int i = 0; i < 32; i++) {
//            if ((n & mask) != 0) {
//                count++;
//            }
//            mask = mask<< 1;
//        }
//        return count;
//    }

    //使用 消除 最低位（次数比上次的少），消除最右边的1
    public int hammingWeight(int n) {
        int count = 0;
        for (; n != 0; n &= (n - 1)) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
