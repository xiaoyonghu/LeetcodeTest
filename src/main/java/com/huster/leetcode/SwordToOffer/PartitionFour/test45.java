package com.huster.leetcode.SwordToOffer.PartitionFour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/4/8
 * Description:把数组排成最小的数
 * Status:有点惊喜，居然学到了Collection的Array的sort方法
 */
public class test45 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("n为"+n);
        int[] num=new int[n];
        for (int i=0;i<n;i++){
            int c=sc.nextInt();
            num[i]=c;
        }
        System.out.println(PrintMinNumber(num));
    }
    public static String PrintMinNumber(int [] numbers) {
        StringBuilder sb=new StringBuilder();
        if(numbers==null || numbers.length==0)
            return "";
       ArrayList<Integer> a=new ArrayList<>();
        int n=numbers.length;
        for (int i = 0; i < n; i++) {
            a.add(numbers[i]);
        }
        //后面一串是排序时需要用到的比较规则，小的在前面，大的在后面
        Collections.sort(a,(s1,s2)->((s1+""+s2).compareTo(s2+""+s1)));
        for (int j:a){
            sb.append(j);
        }


        //思路和上面差不多
        String[] nums=new String[n];
        for (int i = 0; i < n; i++) {
            nums[i]=numbers[i]+"";//使整数变为字符
        }
        Arrays.sort(nums, (s1,s2)->((s1+s2).compareTo(s2+s1)));
        for (String j:nums){
            sb.append(j);
        }

        return sb.toString();


    }
}
