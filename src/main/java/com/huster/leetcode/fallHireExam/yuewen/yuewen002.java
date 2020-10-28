package com.huster.leetcode.fallHireExam.yuewen;

/**
 * @author Created by Divo
 * @date 2020/10/21
 * Description:To Do
 * Status:new
 */
public class yuewen002 {
    public int palindromeCount (String str) {
        int count = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (ishuiwen(str.substring(i,j+1))){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean ishuiwen(String s){
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
}
