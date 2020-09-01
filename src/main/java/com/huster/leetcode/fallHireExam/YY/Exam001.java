package com.huster.leetcode.fallHireExam.YY;

/**
 * @author Created by Divo
 * @date 2020/8/31
 * Description: 比m大的最小的水仙花数
 * Status:unfinished
 *  排查：少一个res++写成了res，<Code>fuck<Code/>
 */
public class Exam001 {

    int temp;
    int k = 10;
    boolean flag = false;
    int res;

    public long nextNarcissisticNumber(int n) {
        res = n + 1;
        while (!flag) {
            if (isSXH(res)) {
                break;
            }
            res++;
        }
        return res;
    }
    boolean isSXH(int m) {
        int j = m;
        int q = m;
        int count = 0;
        while (q > 0) {
            q = q / k;
            count++;
        }
        int sum = 0;
        while (j > 0) {
            temp = j % k;
            j = j / k;
            sum = sum + countM(temp,count);
        }
        return sum == m;
    }

    public int countM(int n, int c) {
        int mms = 1;
        for (int i = 0; i < c; i++) {
            mms = mms * n;
        }
        return mms;
    }

    public static void main(String[] args) {
        Exam001 exam001 = new Exam001();
        System.out.println(exam001.nextNarcissisticNumber(152));
    }
}
