package com.huster.leetcode.fallHireExam.haoWeiLai;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/5
 * Description: 2个字符串中相同的字符的个数
 * Status:new
 */
public class Exam010 {
    public static int getTwoSameString(String s1,String s2){
        HashSet<Character> hashSet1 = new HashSet<>();
        HashSet<Character> hashSet2 = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            hashSet1.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            hashSet2.add(s2.charAt(i));
        }
        hashSet1.retainAll(hashSet2);
        return hashSet1.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        System.out.println(getTwoSameString(s1,s2));
    }
}
