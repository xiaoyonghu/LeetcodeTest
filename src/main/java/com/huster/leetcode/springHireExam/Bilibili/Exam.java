package com.huster.leetcode.springHireExam.Bilibili;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/8/13
 * Description:判断一个数是否归一
 * Status:finished
 */
public class Exam {
    public boolean isGuiYi(int num) {
        int t;
        int res = num;
        while (res >= 10) {
            t = res;
            res = 0;
            while (t > 0) {
                res += (t % 10) * (t % 10);  //取余
                t = t / 10; //取商
            }
        }
        return res == 1 ? true : false;
    }

    public static void main(String[] args) {
        Exam exam = new Exam();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(exam.isGuiYi(sc.nextInt()));
        }
    }
}

