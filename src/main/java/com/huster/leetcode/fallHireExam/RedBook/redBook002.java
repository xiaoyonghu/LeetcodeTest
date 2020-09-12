package com.huster.leetcode.fallHireExam.RedBook;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/12
 * Description:To Do
 * Status:new
 */
public class redBook002 {


    static int res = 0;

    static int solution(String s) {
        res = Math.min(solution1(s),solution2(s));
        return res;
    }

    static int solution1(String s) {
        String s1 = s;
        int count = 0;
        while (s1.length() > 0) {
            char c = s1.charAt(0);
            int lastIndex = s1.lastIndexOf(c);
            s1 = s1.substring(lastIndex + 1);
            count++;
        }
        return count;
    }
    static int solution2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1; i >= 0 ; i--) {
            sb.append(s.charAt(i));
        }
        String s2 = sb.toString();
        int count = 0;
        while (s2.length() > 0) {
            char c = s2.charAt(0);
            int lastIndex = s2.lastIndexOf(c);
            s2 = s2.substring(lastIndex + 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }
        res = solution(_s);
        System.out.println(String.valueOf(res));
    }
}
