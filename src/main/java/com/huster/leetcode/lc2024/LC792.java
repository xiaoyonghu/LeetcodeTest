package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/9 22:08
 * @Desc 匹配子序列的单词数
 */
@Deprecated
public class LC792 {
    public static void main(String[] args) {
        //s = "abcde", words = ["a","bb","acd","ace"]
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq(s, words));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        int totalMatch = 0;
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            if (isSubsequenceUsingTwoPoint(str, s)) {
                totalMatch++;
            }
        }
        return totalMatch;
    }

//    public static boolean isSubsequence(String s, String t) {
//        int len1 = s.length();
//        int len2 = t.length();
//        int i = 0, j = 0;
//        while (i < len1 && j < len2) {
//            if (s.charAt(i) == t.charAt(j)){
//                i++;
//            }
//            j++;
//        }
//        return i == len1;

    // 不管用
//    public static boolean isSubsequenceUsingTwoPoint(String s, String t) {
//        int sLeft = 0;
//        int sRight = s.length() - 1;
//        int tLeft = 0;
//        int tRight = t.length() - 1;
//        int num = 0;
//        while (sLeft <= sRight && tLeft <= tRight) {
//            boolean moveL = false;
//
//            if (s.charAt(sLeft) == t.charAt(tLeft)) {
//                sLeft++;
//            }
//            if (s.charAt(sRight) == t.charAt(tRight)) {
//                sRight--;
//            }
//            tLeft++;
//            tRight--;
//        }
//        return sLeft > sRight;
//    }

    public static boolean isSubsequenceUsingTwoPoint(String s, String t) {
        int sLeft = 0;
        int sRight = s.length() - 1;
        int tLeft = 0;
        int tRight = t.length() - 1;
        int num = 0;
        while (sLeft <= sRight && tLeft <= tRight) {
            if (s.charAt(sLeft) == t.charAt(tLeft)){
                sLeft++;
                tLeft++;
                num++;
            }else if (s.charAt(sRight) == t.charAt(tRight)){
                sRight--;
                tRight--;
                num++;
            }else {
                tLeft++;
                tRight--;
            }
        }
        return num == s.length();
    }

}
