package com.huster.leetcode.fallHireExam.keDaxunfei;

import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/26
 * Description:使用dp
 * Status:finished
 */
public class kedaxunfei001 {
    public static int getNumber(int[][] nums,int n ,int m){
        //使用dp
        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j >=0; j--) {
                nums[i][j] = Math.max(nums[i+1][j],nums[i][j+1]) + nums[i][j];
            }
        }
        return nums[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(",");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        int[][] nums =new int[n+1][m+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        System.out.println(getNumber(nums,n,m));
    }
}
