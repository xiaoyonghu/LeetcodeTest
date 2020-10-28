package com.huster.leetcode.fallHireExam.guanlianda;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/10/14
 * Description:To Do
 * Status:new
 */
public class guanlianda001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String pattern = sc.nextLine();
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            char a1 = s.charAt(i);
            char a2 = pattern.charAt(i);
            if (a1 == a2){
                count += 20;
            }else {
                if (count == 0){
                    count = 0;
                }else {
                    count -= 10;
                }
            }
        }
        System.out.println(count);
    }
}
