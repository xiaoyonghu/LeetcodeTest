package com.huster.leetcode.weizhongbank;

/**
 * @author Created by Divo
 * @date 2020/4/8
 * Description:取出卡片的最大值
 * Status:思路就是选出最大值
 */
import java.util.LinkedList;
import java.util.Scanner;

public class test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //遍历慢，增删快
        LinkedList<int[]> list = new LinkedList<>();
        for(int i = 0; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new int[]{a, b});
        }
        int score = 0;
        int time = 1;
        while (time>0 && list.size()>0){
            int Index_MaxTime=0;
            int MaxTime=0;
            int Index_MaxScore=0;
            int MaxScore=0;
            for (int i = 0; i < list.size(); i++) {
                int[] a=list.get(i);
                if (a[1]>MaxTime){
                    Index_MaxTime=i;
                    MaxTime=a[1];
                }
                if(a[0]>MaxScore){
                    Index_MaxScore=i;
                    MaxScore=a[0];
                }
            }
            if (MaxTime>0){
                time=time+MaxTime-1;//优先考虑次数
                score+=list.remove(Index_MaxTime)[0];//加上抽取次数最多的
            }else {
                time=time-1;//可用次数都为0，此时考虑score最多的
                score+=list.remove(Index_MaxScore)[0];
            }
        }
        System.out.println(score);
    }
}
