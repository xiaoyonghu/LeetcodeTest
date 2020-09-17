package com.huster.leetcode.fallHireExam.vivo;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/12
 * Description:To Do
 * Status:new
 */
public class vivo002 {
    static int[][] direction = {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};
    public static boolean isHuiWen(char[] chars, int n) {
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            if (chars[start] == chars[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        boolean fag =true;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                String ssss = s.substring(i + 1);
                boolean mq = isHuiWen(ssss.toCharArray(), len - 1);
                if (mq) {
                    fag = false;
                    System.out.println(ssss);
                    break;
                }
            } else if (i < len - 1) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i + 1);
                String s3 = s1 + s2;
                boolean huiWen = isHuiWen(s3.toCharArray(), len - 1);
                if (huiWen) {
                    fag = false;
                    System.out.println(s3);
                    break;
                }
            } else if (i == (len - 1)) {
                String sss = s.substring(0, len - 1);
                boolean ok = isHuiWen(sss.toCharArray(), len - 1);
                if (ok) {
                    fag = false;
                    System.out.println(sss);
                    break;
                }
            }
        }
        if (fag){
            System.out.println("false");
        }
    }
}
