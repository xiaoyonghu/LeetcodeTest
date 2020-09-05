package com.huster.leetcode.fallHireExam.baidu;


import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/3
 * Description:牛牛卡片  5 0  整除90
 * Status:new
 */
public class Exam001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count5 = 0;
        int count0 = 0;
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt();
            if (c == 5)
                count5++;
            if (c == 0)
                count0++;

        }
        if (count0 == 0 || count5 < 8)
            System.out.println("-1");
        int k = count5 / 9;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k * 9; i++) {
            sb.append("5");
        }
        for (int i = 0; i < count0; i++) {
            sb.append("0");
        }
        System.out.println(sb.toString());
    }
}
