package com.huster.leetcode.BaiduNewCoderTest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Created by Divo
 * @date 2020/3/29
 * Description:用来输入输出练手,求价格的第3位数
 * Status:new
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count = sc.nextInt();
        int level = 1;
        int []price = new int[count];
        for (int i = 0; i <count ; i++) {
            price[i]=sc.nextInt();
        }
       /**
        //使用Treeset数据结构，使用TreeMap 底层使用红黑树
        Set<Integer> set=new TreeSet<>();
        for (int i = 0; i <count ; i++) {
            set.add(count);
        }
        if (set.size()<3)
            System.out.println(-1);
        else
            System.out.println(set.toArray()[2]);
        */
        Arrays.sort(price);
        for (int j = 1; j <count ; j++) {
            if (price[j-1]<price[j])
                level++;
            if (level == 3) {
                System.out.println(price[j]);
                break;
            }
        }
        if (level < 3)
            System.out.println(-1);
    }
}
