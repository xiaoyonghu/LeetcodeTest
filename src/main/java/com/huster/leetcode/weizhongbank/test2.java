package com.huster.leetcode.weizhongbank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/4/8
 * Description: 我靠，自己平时写的时候多注意一点，要学会适应题意
 * Status:
 */
public class test2 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        //System.out.println(n);
        ArrayList<String> arrayList=new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            String a=sc.next();
            //System.out.println(a);
            //System.out.println(whowin(a));
            arrayList.add(whowin(a));
        }
        for (String s:arrayList){
            System.out.println(s);
        }

    }
    public static String whowin(String s) {
        HashSet<Character> hashSet=new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(hashSet.contains(c)){
                hashSet.remove(c);
            }else{
                hashSet.add(c);
            }
        }
        return (hashSet.size()-1)%2 == 0 ? "Cassidy":"Eleanore";
    }
}
