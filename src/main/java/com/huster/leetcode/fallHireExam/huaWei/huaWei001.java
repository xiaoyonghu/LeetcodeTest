package com.huster.leetcode.fallHireExam.huaWei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/9
 * Description:玩具的完美排列  KMP算法找字符串
 * Status:finished
 */
public class huaWei001 {
    public static int getPerfectToysIndex(List<Integer> conceptFor,List<Integer> conceptList,List<Integer> valueFor,List<Integer> valueList){
        //indexOfSubList底层使用KMP算法
        int conceptFirstIndex = Collections.indexOfSubList(conceptList,conceptFor);
        if (conceptFirstIndex == -1)
            return 0;

        int valueFirstIndex = Collections.indexOfSubList(valueList,valueFor);
        if (valueFirstIndex == -1)
            return 0;

        if (conceptFirstIndex == valueFirstIndex)
            return conceptFirstIndex+1;

        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<Integer> concept0ne = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            concept0ne.add(sc.nextInt());
        }
        sc.nextLine();

        ArrayList<Integer> valueOne = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            valueOne.add(sc.nextInt());
        }
        sc.nextLine();

        int Total = sc.nextInt();
        sc.nextLine();

        ArrayList<Integer> conceptTwo = new ArrayList<>();

        for (int i = 0; i < Total; i++) {
            conceptTwo.add(sc.nextInt());
        }
        sc.nextLine();

        ArrayList<Integer> valueTwo = new ArrayList<>();
        for (int i = 0; i < Total; i++) {
            valueTwo.add(sc.nextInt());
        }
        sc.nextLine();

        System.out.println(getPerfectToysIndex(concept0ne,conceptTwo,valueOne,valueTwo));

    }
}
