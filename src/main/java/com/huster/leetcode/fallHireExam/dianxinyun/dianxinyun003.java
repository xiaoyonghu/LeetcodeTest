package com.huster.leetcode.fallHireExam.dianxinyun;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/10/15
 * Description:To Do
 * Status:new
 */
public class dianxinyun003 {
    public static String getCommonPrex(String[] arr){
        if (arr == null || arr.length == 0){
            return "";
        }
        String prex =arr[0];
        int count = arr.length;
        for (int i = 1; i < count; i++) {
            prex  = getLongPrex(prex,arr[i]);
           if (prex.length() == 0){
               break;
           }
        }
        return prex;
    }

    private static String getLongPrex(String s1, String s2) {
        int n = Math.min(s1.length(),s2.length());
        int index = 0;
        while (index<n && s1.charAt(index) == s2.charAt(index)){
            index++;
        }
        return s1.substring(0,index);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(",");
        System.out.println(arr.toString());
        //String commonPrex = getCommonPrex(arr);
        //System.out.println(commonPrex);
    }
}
