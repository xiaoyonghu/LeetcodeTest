package com.huster.leetcode.Leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/8/29
 * Description:lc 214 最短回文串
 * Status:unfinished
 * 思路：主要思路就是前面的一部分为回文，解决后面的不是回文的问题
 * kmp 马拉车算法
 */
public class Exam214 {
    /**
     * 下面这种思路解决的是找全局最短的
     */
    //思路一，可以与最长重复回文子串结合起来O（n）
    public String shortestPalindrome(String s) {
        int n = s.length();
        int arr[] = new int[2];
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            i = findLPSBased(chars, i, arr, n);
        }
        int left = arr[0];
        int right = arr[1];


        StringBuilder sb = new StringBuilder();
        int rLeft = n - right - 1;
        int lLeft = left;
        int temp = n - 1;

        //先加最长回文子串最右边的
        while (rLeft > 0) {
            sb.append(chars[temp--]);
            rLeft--;
        }

        //加入整个前面未匹配和最长回文子串
        for (int i = 0; i <= right; i++) {
            sb.append(chars[i]);
        }

        //加入最左边的未匹配
        temp = left - 1;
        while (lLeft > 0) {
            sb.append(chars[temp--]);
            lLeft--;
        }

        //加入最后末尾的
        for (int i = right + 1; i < n; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    private int findLPSBased(char[] chars, int low, int[] arr, int length) {
        //看成2部分，一部分为中间相等，另外一部分为旁边2边相等
        int high = low;
        while (high < length - 1 && (chars[high + 1] == chars[low])) {
            high++;
        }
        int ans = high;
        while (low > 0 && (high < length - 1) && chars[low - 1] == chars[high + 1]) {
            low--;
            high++;
        }
        if ((arr[1] - arr[0]) < (high - low)) {
            arr[1] = high;
            arr[0] = low;
        }
        return ans;
    }

    /**
     * 解法一：原始字符串先逆序，然后截取逆序后的前i个字符拼接到原串上，取满足回文条件最小的i
     */
    public String shortestPalindrome1(String s) {
        int n =s.length();
        if (n == 0)
            return "";
        if (n ==1)
            return s;
        if (isHuiWen(s)){
            return s;
        }
        char[] c=s.toCharArray();
        char[] rev=new char[n];
        for (int i = 0,j=n-1; i < n; i++,j--) {
            rev[i] = c[j];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(rev[i]);
        }
        String resS=sb.toString();

        int min=Integer.MAX_VALUE;
        boolean huiWen;
        String pingJie;

        for (int i = 0; i < n; i++) {
            String si=resS.substring(0,i+1);
            pingJie = si+s;
            huiWen = isHuiWen(pingJie);
            if (huiWen && (min>i+1)){
                min=i+1;
            }
        }
        return resS.substring(0,min)+s;
    }
    public boolean isHuiWen(String s){
        boolean flag=true;
        int left=0;
        int right = s.length()-1;
        while(left<=right){
            if (s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else {
                flag=false;
                break;
            }
        }
        return flag;
    }

    public String shortestPalindrome2(String s) {
        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int best = -1;
        for (int i = n - 1; i >= 0; --i) {
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                ++best;
            }
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Exam214 exam214 = new Exam214();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.println(exam214.shortestPalindrome1(s));
        }
    }
}
