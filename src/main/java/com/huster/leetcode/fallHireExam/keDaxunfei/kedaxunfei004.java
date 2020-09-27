package com.huster.leetcode.fallHireExam.keDaxunfei;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/26
 * Description:分解质因数  50 = 2*5*5
 * Status:finished
 */
public class kedaxunfei004 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuffer sb = new StringBuffer();

        while (n >0) {
            boolean flag =true;
            int mid = (int) Math.sqrt(n);
            for (int i = 2; i <= mid; i++) {
                if ((n % i) == 0) {
                    sb.append(i + "*");
                    n = n / i;
                    flag = false;
                    break;
                }
            }
            if (flag){
                sb.append(n + "");
                break; //跳出最外层的循环
            }
        }
        System.out.println(sb.toString());
    }
}
