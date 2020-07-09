package com.huster.leetcode.kuaishou;

import java.util.ArrayList;

/**
 * @author Created by Divo
 * @date 2020/4/12
 * Description:快手第二题
 * 开始的时候得把思路搞清楚，搞清楚了就很好做了
 * 这点很重要
 * Status:new
 */
public class test2 {
    public static void main(String[] args) {
        System.out.println(getS(1,3));
        //System.out.println(arrayList);
    }
    public static ArrayList getS(int R,int N){
        ArrayList<Integer> arrayList=new ArrayList<>();
        int count=0;
        if (R<N){
            arrayList.add(0);
            return arrayList;
        }
        int n=R/N,m=R%N;
        if (m!=0){
            return arrayList;
        }else {
            if(n==0){
                arrayList.add(0);
                return arrayList;
            }else {
                while (n!=0){
                    if (m>1 && m<N){
                        arrayList.clear();
                        return arrayList;
                    }else if(m!=0){
                        arrayList.add(count);
                    }
                    m=n%N;
                    n=n/N;
                    count++;
                }
                if (m>1 && m<N){
                    arrayList.clear();
                    return arrayList;
                }else if (m==1){
                    arrayList.add(count);
                }
            }
        }
        return arrayList;
    }
}
