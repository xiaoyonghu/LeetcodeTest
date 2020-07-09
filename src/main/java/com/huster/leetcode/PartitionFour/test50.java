package com.huster.leetcode.PartitionFour;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/4/12
 * Description:第一个只出现一次的字符
 * Thought：第一次扫描一遍，hashmap《Char,count》
 *          第二遍扫描，找出对于的字符出现的次数为1
 */
public class test50 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(FirstNotRepeatingChar(sc.next()));
        }
        sc.close();
    }


    public static int FirstNotRepeatingChar(String str) {
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c=str.charAt(i);
            if (hashMap.containsKey(c)){
                hashMap.put(c,hashMap.get(c)+1);
            }else {
                hashMap.put(c,1);
            }
        }
        for (int j = 0; j < str.length(); j++) {
            char c=str.charAt(j);
            if (hashMap.get(c) == 1){
                return j;
            }
        }
        return -1;
    }
}
