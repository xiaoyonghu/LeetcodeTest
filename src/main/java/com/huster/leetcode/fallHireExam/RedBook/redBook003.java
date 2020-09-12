package com.huster.leetcode.fallHireExam.RedBook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Divo
 * @date 2020/9/12
 * Description: 叠箱子  三维数组  对前 1 2列进行排序，然后找最长的上升子序列
 * Status:unfinished
 */
public class redBook003 {
    public int getMaxheight(List<List<Integer>> arr, int n) {
        int total = n * 3;
        int[][][] sanWei =new int[total][total][total];
        List<List<Integer>> totalList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = arr.get(i);

            int a, b, c;
            a = list.get(0);
            b = list.get(1);
            c = list.get(2);
            totalList.add(list);

            List<Integer> tmp = new ArrayList<>();
            tmp.add(a);
            tmp.add(c);
            tmp.add(b);
            totalList.add(new ArrayList<>(tmp));

            List<Integer> tmp1 = new ArrayList<>();
            tmp.add(c);
            tmp.add(a);
            tmp.add(b);
            totalList.add(new ArrayList<>(tmp1));
        }

        //Arrays.sort(totalList, (Comparator<T>) (o1, o2) -> 0);

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(23);
        System.out.println();
    }
}
