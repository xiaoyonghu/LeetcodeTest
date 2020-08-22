package com.huster.leetcode.fallHireExam.test360;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/8/22
 * Description:8.22 360笔试
 *      判断一系列的字符串是否满足需求
 * Status:finished
 */
public class Exam1 {
    static final int limit = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int result = 0;
        while (n > 0) {
            String s = sc.nextLine();
            if (s.length() > limit) {
                n--;
                continue;
            }
            int countTrue = 0;
            int countFalse = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                    countTrue++;
                } else {
                    countFalse++;
                    break;
                }
            }
            if (countTrue == s.length()) {
                n--;
                result++;
            }
            if (countFalse > 0) {
                n--;
            }
        }
        System.out.println(result);
    }
}

