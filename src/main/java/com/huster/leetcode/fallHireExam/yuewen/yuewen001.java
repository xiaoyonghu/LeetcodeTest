package com.huster.leetcode.fallHireExam.yuewen;

import java.util.HashMap;

/**
 * @author Created by Divo
 * @date 2020/10/21
 * Description:To Do
 * Status:new
 */
public class yuewen001 {
    public String removeDuplicatedChars (String str) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!hashMap.containsKey(c)){
               sb.append(c);
               hashMap.put(c,1);
            }
        }
        return sb.toString();
    }
}
