package com.huster.leetcode.meituan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/4/23
 * Description:
 * 两个数是相似的，当且仅当他们位与起来不为0。例如，3和5是相似的，因为3的二进制为011,5的二进制为101,他们位与起来为001不为0。
 * 现在，给出序列a1,a2…an我们希望你找出，对于任意的i∈[1,n]，是否存在j∈[1,n]，使得ai,aj不相似。
 * Status:new
 */
public class test5 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        ArrayList<Integer> a=new ArrayList<>(n);
        ArrayList<Integer> b=new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        //System.out.println(a.toString());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isNotSim(a.get(i),a.get(j))){
                    b.add(1);
                    break; //内层循环结束
                }else {
                    if (j == n-1){
                        b.add(-1);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(b.get(i)+" ");
            //System.out.println(b.toString());
        }
    }
    public static Boolean isNotSim(int i,int j){
        boolean NotSim=false;
        int a=i & j;
        if (a == 0){
            NotSim = true;
        }
        return NotSim;
    }
}
