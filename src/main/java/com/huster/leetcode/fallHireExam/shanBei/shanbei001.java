package com.huster.leetcode.fallHireExam.shanBei;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/7
 * Description:牛牛和牛妹的猜拳问题
 * Status:new
 */
public class shanbei001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        while (T > 0) {
            char[] niuMei = new char[2];
            char[] niuNiu = new char[2];

            for (int i = 0; i < 2; i++) {
                niuMei[i] = sc.next().charAt(0);
            }

            for (int i = 0; i < 2; i++) {
                niuNiu[i] = sc.next().charAt(0);
            }

            int[] win = new int[2];
            for (int i = 0; i < 2; i++) {
                if (niuMei[i] == 'J') {
                    for (int j = 0; j < 2; j++) {
                        if (niuNiu[j] == 'B') {
                            win[i]++;
                        }
                    }
                } else if (niuMei[i] == 'S') {
                    for (int j = 0; j < 2; j++) {
                        if (niuNiu[j] == 'J') {
                            win[i]++;
                        }
                    }
                } else if (niuMei[i] == 'B') {
                    for (int j = 0; j < 2; j++) {
                        if (niuNiu[j] == 'S') {
                            win[i]++;
                        }
                    }
                }
            }
            if (win[0] > win[1]) {
                System.out.println("left");
            } else if (win[0] < win[1]) {
                System.out.println("right");
            } else {
                System.out.println("same");
            }
            T--;
        }
    }
}
