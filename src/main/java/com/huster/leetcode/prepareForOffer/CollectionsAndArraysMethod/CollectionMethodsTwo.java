package com.huster.leetcode.prepareForOffer.CollectionsAndArraysMethod;

import java.util.ArrayList;
import java.util.Collections;


/**
 * @author Created by Divo
 * @date 2020/9/9
 * Description:用来测试Collection的一些常见函数
 * Status:unfinished
 */
public class CollectionMethodsTwo {

    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(-1);
//        arrayList.add(3);
//        arrayList.add(3);
//        arrayList.add(-5);
//        arrayList.add(7);
//        arrayList.add(4);
//        arrayList.add(-9);
//        arrayList.add(-7);
//
//        /**
//         * 1、binarySearch
//         * List进行二分查找，返回索引，注意List必须是有序的
//         */
//        System.out.println("原始数组");
//        System.out.println(arrayList);
//        int i = Collections.binarySearch(arrayList, 7);
//        System.out.println("Collections.reverse(arrayList):");
//        System.out.println(i);
//
//        /**
//         * 2、max(Collection coll)    根据元素的自然顺序，返回最大的元素。 类比int min(Collection coll)
//         * 3、max(Collection coll, Comparator c)  根据定制排序，返回最大元素，排序规则由Comparatator类控制。类比int min(Collection coll, Comparator c)
//         */
//        Integer max = Collections.max(arrayList);
//        System.out.println(max);
//
//        /**
//         * 3、replaceAll
//         * 用新元素替换旧元素
//         */
//        Collections.replaceAll(arrayList, 3, 11);
//        System.out.println("---------->");
//        System.out.println(arrayList);
//
//
//        /**
//         * 4、frequency方法
//         * 统计元素出现次数
//         */
//        int frequency = Collections.frequency(arrayList, 2);
//        System.out.println("出现的次数：" + frequency);
//
//        /**
//         * 5、fill
//         * 用指定的元素代替指定list中的所有元素。
//         */
//        Collections.fill(arrayList,88);
//        System.out.println(arrayList);

        /**
         * 6、indexOfSubList
         * 统计target在list中第一次出现的索引，找不到则返回-1，类比int lastIndexOfSubList(List source, list target).
         */

        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(1);
        arrayList2.add(2);
        arrayList2.add(1);
        arrayList2.add(2);
        arrayList2.add(3);
        arrayList2.add(3);

        ArrayList<Integer> arrayList3 = new ArrayList<>();
        arrayList3.add(1);
        arrayList3.add(2);
        arrayList3.add(3);

        int firstIndex = Collections.indexOfSubList(arrayList2, arrayList3);
        System.out.println(firstIndex);


    }
}
