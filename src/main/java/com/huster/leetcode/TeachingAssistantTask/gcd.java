package com.huster.leetcode.TeachingAssistantTask;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2019/10/12
 * Description:最大公约数
 * Status:finished
 */
public class gcd {
    public static void main(String args[])
    {
        Scanner cin=new Scanner(System.in);
        while(cin.hasNext()){
            int a=cin.nextInt();
            int b=cin.nextInt();
            System.out.println(gcd(a, b));
        }
    }

    // 最大公约数
    public static int gcd(int n1, int n2) {
        // TODO  直接blog，辗转相除
        while(n2!=0)
        {
            int r=n1%n2;
            n1=n2;
            n2=r;
        }
        return n1;

    }
}
