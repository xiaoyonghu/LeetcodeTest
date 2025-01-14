package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/8 22:00
 * @Desc 判断子序列
 */
public class LC392 {
    public static void main(String[] args) {

//        String s = "abc", t = "ahbgdc";  // true
//        String s = "axc", t ="ahbgdc";
        String s = "axc", t ="ahbgdc";
        System.out.println(isSubsequenceUsingTwoPoint(s, t));
    }

    // 使用一端来进行比较
    public boolean isSubsequenceUsingOnePoint(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }
            if (i == len1) return true;
            j++;
        }
        return i == len1;
    }

    //  String s = "abc", t = "ahbgdc";  // true
    // String s = "axc", t ="ahbgdc"
    // String s = "abbc", t ="ahbdc"
//    public static boolean isSubsequenceUsingTwoPoint(String s, String t) {
//        int sLeft = 0;
//        int sRight = s.length() - 1;
//        int tLeft = 0;
//        int tRight = t.length() - 1;
//
//        while (sLeft <= sRight && tLeft <= tRight) {
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
