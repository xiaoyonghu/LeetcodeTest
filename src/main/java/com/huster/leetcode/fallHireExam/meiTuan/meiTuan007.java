package com.huster.leetcode.fallHireExam.meiTuan;

/**
 * @author Created by Divo
 * @date 2020/9/20
 * Description:
 * Status:new
 */
public class meiTuan007 {
    static int gradeScore = 0;
    public int getNumber(int n ,int m,char[][] chars,String s,int FromX,int FromY){
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == 'W'){

            }else if(c == 'S'){

            }else if(c == 'A'){

            }else if(c == 'D'){
                return 1;
            }
        }
        return gradeScore;
    }
}
