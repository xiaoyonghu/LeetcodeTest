package com.huster.leetcode.fallHireExam.keDaxunfei;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/26
 * Description: 进行下划线的消除 或者__fdfd__dfgdg_df____ef_  --> fdfd_dfgdg_df_ef
 * Status:finished
 */
public class kedaxunfei003 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len1 = s.length();
        int start = 0;
        for (int i = 0; i < len1; i++) {
            char c = s.charAt(i);
            if (c != '_') {
                start = i;
                break;
            }
        }

        int end = 0;
        for (int i = len1 - 1; i >= 0; i--) {
            if (s.charAt(i) != '_') {
                end = i;
                break;
            }
        }

        String ss;
        ss = s.substring(start, end + 1);

        int len = ss.length();
        Boolean flag = false;
        for (int i = 0; i < len; i++) {
            char c = ss.charAt(i);
            if (c != '_') {
                sb.append(c);
                flag = false;
            } else {
                if (!flag) {
                    sb.append(c); //加第一个 _
                    flag = true;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
