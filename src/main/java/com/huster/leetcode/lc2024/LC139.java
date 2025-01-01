package com.huster.leetcode.lc2024;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/1 13:19
 * @Desc 单词拆分 DP
 */
public class LC139 {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple", "pen");

//        String s = "catsandog";
//        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        // true
        System.out.println(wordBreak(s, wordDict));
    }

    // 21:15 暂时没啥思路
    // 下面这种思路完全不对
    @Deprecated
    public static boolean wordBreakDeprecated(String s, List<String> wordDict) {
        // 1、不是DP （用set记录是否有包含在其中，然后每一个都移动）
        Set<String> set = new HashSet<>();
        int wordMaxLength= 0;

        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
            wordMaxLength = Math.max(wordMaxLength, wordDict.get(i).length());
        }

        int i = 0, j = 0;
        boolean containsFlag = true;
        while (j < s.length()) {
            if ((j - i + 1) > wordMaxLength) {
                containsFlag = false;
                break;
            }
            String subStr = s.substring(i, j + 1);
            if (set.contains(subStr)) {
                i = j;
                i++;
            }
            j++;
        }
        return containsFlag;
    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        // 使用dp
        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }

        // dp[i]表示[0-i]是可以由wordDict拼接出来
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        // 动态转移方程
        // 由于有多个元素，不确定性，都可以拼接，所以第二层需要用一层for循环，基本思想
        // 这里以i为下标（s.substring(j, i)）去截取，感觉限制的有限死
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // leetcode
                // "leet", "code"
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
