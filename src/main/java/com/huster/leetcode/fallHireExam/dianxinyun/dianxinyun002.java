package com.huster.leetcode.fallHireExam.dianxinyun;


import java.util.Arrays;

/**
 * @author Created by Divo
 * @date 2020/10/15
 * Description:To Do
 * Status:new
 */
public class dianxinyun002 {
    public static void main(String[] args) {
        int target = 8888;
        int a, b, c, d;
        int[] res = new int[100];
        int count = 0;
        int index = 0;
        for (int i = 0; i < 10000; i++) {
            a = i / 1000;
            b = (i - a * 1000) / 100;
            c = (i - a * 1000 - b * 100) / 10;
            d = i - a * 1000 - b * 100 - c * 10;
            if ((i + b * 1000 + c * 100 + d * 10 + a) == target && (d >= 0)) {
//                res[index] = i;
//                index = index + 1;
//                count = count + 1;
                System.out.println(a + " " + b + " " + c + " " + d);
            }
        }
        Arrays.sort(res);
//        for (int i = 0; i < count; i++) {
//            int num = res[i];
//            a = num / 1000;
//            b = (num - a * 1000) / 100;
//            c = (num - a * 1000 - b * 100) / 10;
//            d = num - a * 1000 - b * 100 - c;
//            System.out.println(a + " " + b + " " + c + " " + d);
//        }
    }
}
