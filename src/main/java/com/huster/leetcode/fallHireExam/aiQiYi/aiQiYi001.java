package com.huster.leetcode.fallHireExam.aiQiYi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/13
 * Description: lc
 * Status:new
 */
public class aiQiYi001 {
    public static int getMaxLen(String s) {
        int[] ss = new int[256];
        Arrays.fill(ss, -1);
        int res = 0, start = -1;
        for (int i = 0; i < s.length(); i++) {
            start = Math.max(start, ss[s.charAt(i)]);
            ss[s.charAt(i)] = i;
            res = Math.max(res, i - start);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getMaxLen(s));
    }
}
