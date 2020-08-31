package com.huster.leetcode.fallHireExam.RedBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/8/30
 * Description:
 * Status:未做出来
 */
public  class Exam001 {
    int SIZE=102;
    public String[] splitMsg(String textContent){
        //String[] result=new String[100];
        ArrayList<String> s = new ArrayList<>();

        String[] s1=textContent.split("\\n");
       // int j=0;
        int duanSize =s1.length;
        for (int i = 0; i < duanSize; i++) {
            String temp = s1[i];
            if (temp.length()>SIZE){
                String[] juZi=temp.split("\\.");
                int m = juZi.length;
                for (int k = 0; k < m; k++) {
                   // System.out.println(juZi[k]+":"+juZi[k].length());
                    s.add(juZi[k]);
                }
            }else {
               // System.out.println(temp+":"+temp.length());
                s.add(temp);
            }
        }
        String[] res = new String[s.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = s.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in);
        String s1="fdjfhdj ";
        String s2="fhdjfdfdf";
        String s3="erererewrqwe ";
        String s4="3434545434 ";
        String del=".";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            sb.append(s1).append(s2);
            if (i%5==0)
                sb.append(del);
        }
        sb.append("\n");
        for (int i = 0; i < 30; i++) {
            sb.append(s3).append(s4);
            if (i%5==0)
                sb.append(del);
        }
        Exam001 exam001 = new Exam001();
        //System.out.println();
        String[] result=exam001.splitMsg(sb.toString());
        for (String s:result){
            System.out.println(s);
        }
    }
}
