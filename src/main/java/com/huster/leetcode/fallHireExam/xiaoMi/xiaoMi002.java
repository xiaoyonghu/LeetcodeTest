package com.huster.leetcode.fallHireExam.xiaoMi;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/15
 * Description:To Do
 * Status:new
 */
public class xiaoMi002 {
    public static String getString(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() ; i++) {
            char c =s.charAt(i);
            if (!map.containsKey(c)){
               map.put(c,1);
               sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getString(s));
    }
}
