package com.huster.leetcode.fallHireExam.FiveTongceng;

/**
 * @author Created by Divo
 * @date 2020/10/11
 * Description:看B后面有多少个G
 * Status:finished
 */
public class FiveTongceng003 {
    public int lineup (String peoples) {
        int count1 = 0;
        int count2 = 0;
        int len =peoples.length();
        for (int i = 0; i < len; i++) {
            char c =peoples.charAt(i);
            if (c == 'B'){
                for (int j = i; j < len; j++) {
                    char cc = peoples.charAt(j);
                    if (cc == 'G'){
                        count1++;
                    }
                }
            }
        }
        for (int i = 0; i < len; i++) {
            char c =peoples.charAt(i);
            if (c == 'G'){
                for (int j = i; j < len; j++) {
                    char cc = peoples.charAt(j);
                    if (cc == 'B'){
                        count2++;
                    }
                }
            }
        }

        return Math.min(count2,count1);
    }
}
