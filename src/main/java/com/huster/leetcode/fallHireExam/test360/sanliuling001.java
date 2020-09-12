package com.huster.leetcode.fallHireExam.test360;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/11
 * Description:360判断密码是否合法
 * Status:finished
 */
public class sanliuling001 {
    static public String isOK(String s) {
        boolean NumberExist = false;
        boolean UpperExist = false;
        boolean LowExist = false;
        boolean SpecialExit = false;

        int len = s.length();
        {
            if (len < 8)
                return "Irregular password";
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                NumberExist = true;
                continue;
            }
            if (c >= 'A' && c <= 'Z') {
                UpperExist = true;
                continue;
            }
            if (c >= 'a' && c <= 'z') {
                LowExist = true;
                continue;
            }
            SpecialExit = true;
        }
        if (NumberExist && SpecialExit && UpperExist && LowExist)
            return "OK";
        return "Irregular password";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> res = new ArrayList<>();
        for (;sc.hasNextLine(); ) {
            String input = sc.nextLine();
            String s = isOK(input);
            res.add(s);
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
