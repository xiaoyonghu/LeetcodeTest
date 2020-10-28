package com.huster.leetcode.fallHireExam.pingduoduo;

import java.util.HashMap;


/**
 * @author Created by Divoimport java.util.Stack;
 * @date 2020/10/23
 * Description: 找最长的数  mmp  依图  10.27 我靠  没ac出来，刷题太少了  难受
 * Status:
 */
public class pingduoduo003 {
    public int getMax(String s){
        HashMap<Character, Integer> hashMap = new HashMap<>();
        HashMap<Integer, Integer> resMap = new HashMap<>();
        int maxLen = 1;
        int len = s.length();
        int i = 0;
        int j = 1;
        char c = s.charAt(0);
        resMap.put(0,1);
        hashMap.put(c,1);
        while (j<len){
            if ( s.charAt(i) == s.charAt(j)){
                int length = j -i;
                if (length > maxLen){
                   int target = hashMap.get(s.charAt(i));
                   i = target +1;
                   //resMap.put()
                }else {
                    //Stack<Integer> stack = new Stack<>();
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
