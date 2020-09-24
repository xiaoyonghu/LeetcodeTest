package com.huster.leetcode.fallHireExam.laoHu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/20
 * Description:To Do
 * Status:new
 */
public class laoHu001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int K = sc.nextInt();
        int[] costs =new int[N];
        int[] profits =new int[N];
        for (int i = 0; i < N; i++) {
            costs[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            profits[i] = sc.nextInt();
        }

        boolean[] used = new boolean[N];
        Arrays.fill(used,false);
        while (K>0){
            int maxProfit = Integer.MIN_VALUE;
            int index  = 0;
            for (int i = 0; i < N; i++) {
                if (!used[i] && W>=costs[i]){
                    if (maxProfit<=profits[i]){
                        maxProfit = profits[i];
                        index = i;
                    }
                }
            }

            W+= profits[index];
            used[index] = true;

            K--;
        }
        System.out.println(W);
    }
}
