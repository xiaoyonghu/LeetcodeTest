package com.huster.leetcode.Leetcode;

/**
 * @author Created by Divo
 * @date 2020/7/26
 * Description:最长回文子串
 * Status:finished
 */
public class Exam5 {
    public String longestPalindrome(String s) {
        int[] arr = new int[2];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
           i = findLPSBasedI(chars,i,arr);
        }
                            //include  exclusive
        return s.substring(arr[0],arr[1]+1);
    }
    int findLPSBasedI(char[] chars,int low,int[] arr){
        //1、找跟i节点相同的最右边的index
        int high = low;
        while ( high < chars.length -1 && (chars[high + 1] == chars[low])){
            high++;
        }
        //ans的值为最后一个与low节点所对应的值相等的节点,可以加快主循环的速度
        int ans = high;
        //以low high为中间部分 向2遍扩散
        while (low >0 && (high < chars.length-1) && chars[low-1] == chars[high+1]){
            low--;
            high++;
        }
        if ((arr[1] - arr[0]) < (high - low)){
            arr[0] = low;
            arr[1] = high;
        }
        return ans;
    }
    public static void main(String[] args) {
        String s="cbbd";
        Exam5 exam5 = new Exam5();
        System.out.println(exam5.longestPalindrome(s));
    }
}
