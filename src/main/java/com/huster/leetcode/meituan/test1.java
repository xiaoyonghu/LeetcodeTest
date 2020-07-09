package com.huster.leetcode.meituan;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Created by Divo
 * @date 2020/4/23
 * Description:星星问题，如果一个2位坐标的上、下、左、右都有即为幸运星
 *                                 其中上下左右不必连接在一起
 * Status:
 * 时间不允许，需要多刷题，先写开题报告
 */
public class test1  {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<int[]> arr=new ArrayList<>(n);
        ArrayList<int[]> result=new ArrayList<>(n);
        HashMap<Integer,ArrayList<Integer>> lhash=new HashMap<>(n);
        HashMap<Integer,ArrayList<Integer>> rhash=new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int[] c=new int[]{a,b};
            arr.add(c);

            if (lhash.containsKey(a)){
                ArrayList<Integer> arrayList;
                arrayList=lhash.get(a);
                arrayList.add(b);
                lhash.put(a,arrayList);
            }else {
                ArrayList<Integer> arrayList=new ArrayList<>();
                arrayList.add(b);
                lhash.put(a,arrayList);
            }

            if (rhash.containsKey(b)){
                ArrayList<Integer> arrayList;
                arrayList=lhash.get(b);
                arrayList.add(a);
                rhash.put(b,arrayList);
            }else {
                ArrayList<Integer> arrayList=new ArrayList<>();
                arrayList.add(a);
                rhash.put(b,arrayList);
            }
        }
        for (int i = 0; i < n; i++) {
            int[] ac=arr.get(i);
            int a=ac[0];
            int b=ac[1];
            //判断上下
            if (lhash.get(ac[0]).size()<=2){
                //没戏了，啥也不做
            }else {
                //判断其值是不是有上、下
                ArrayList<Integer> arrayList=lhash.get(ac[0]);
                Boolean up=false,down=false;
                for (int j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(j)<b)
                        down=true;
                    if (arrayList.get(i)>b)
                        up=true;
                    //上下成立
                    if (up&down){
                        //判断左右
                        Boolean left=false,right=false;
                        if (rhash.get(b).size()<=2){
                        }else {
                            ArrayList<Integer> arrayList1=rhash.get(b);
                            for (int k = 0; k < arrayList1.size(); k++) {
                                if (arrayList.get(k)<a)
                                    left=true;
                                if (arrayList.get(i)>b)
                                    right=true;
                                if (left&right)
                                    break;
                            }


                            //此时左右也成立了
                            if (left&right)
                                result.add(arr.get(i));
                        }
                    }
                }
            }
        }

    }
}
