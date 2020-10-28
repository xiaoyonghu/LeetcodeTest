package com.huster.leetcode.fallHireExam.pingduoduo;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/10/23
 * Description:
 * Status:new
 */
public class pingduoduo002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        char[] arr = new char[len];
        HashMap<Character, Integer> map = new HashMap<>();
        //StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            arr[i] = c;
            if (!map.containsKey(c)){
                map.put(c,1);
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String substring = s.substring(i,j+1);
                //isExit();
            }
        }


    }
}
