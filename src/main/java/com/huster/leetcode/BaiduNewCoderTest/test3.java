package com.huster.leetcode.BaiduNewCoderTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/3/29
 * Description:将数组中任意位置的数 放在数组的最后一个位置，操作多少次可以使得数组从小到大排序
 *    感觉和求逆序（2路归并）对不一样
 * Status:new
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr= new int[n];
        int[] sortedArr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=sc.nextInt();
            sortedArr[i]=arr[i];
        }
        Arrays.sort(sortedArr);
        int count=0;  //不需要移动的数
        int j=0;
        for (int i = 0; i <n ; i++) {
            if (arr[i] == sortedArr[j]){
                count++;
                j++;
            }
        }
        System.out.println(n-count);

    }
}
