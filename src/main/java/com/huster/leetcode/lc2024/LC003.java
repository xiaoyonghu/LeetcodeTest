package com.huster.leetcode.lc2024;

import java.util.HashMap;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/26 22:32
 * @Desc  无重复字符的最长子串 滑动窗口
 */
public class LC003 {
    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
        String s = "tmmzuxt";
        // target = 3
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * @Description
     **/
    public static int lengthOfLongestSubstring(String s) {
        // 1、使用窗口和map
        HashMap<Character, Integer> indexMap = new HashMap<>();
        int len = s.length();
        int maxLength = 0;
        int l = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (indexMap.containsKey(c)) {
                Integer containIndex = indexMap.get(c);
                indexMap.put(c, i); //更新已经存在字符的下标
                if (containIndex < l) { // 如果包含的字符的坐标都不在滑动窗口里面，直接废弃
                    maxLength = Math.max(maxLength, i - l + 1);
                }else {
                    l = containIndex + 1;
                }
            } else {
                indexMap.put(c, i);
                maxLength = Math.max(maxLength, i - l + 1);
            }
        }
        return maxLength;
    }
}
