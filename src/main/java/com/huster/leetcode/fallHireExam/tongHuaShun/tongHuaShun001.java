package com.huster.leetcode.fallHireExam.tongHuaShun;

import java.util.ArrayList;

/**
 * @author Created by Divo
 * @date 2020/9/18
 * Description:输出1-999中不包含5的整数
 * Status:new
 */
public class tongHuaShun001 {
    public static void main(String[] args) {
        int N = 999;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (isValid1(i)) {
                list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static boolean isValid1(int num) {
        while (num > 0) {
            int n = num % 10;
            if (n == 5){
                return false;
            }
            num = num / 10;
        }
        return true;
    }
}
