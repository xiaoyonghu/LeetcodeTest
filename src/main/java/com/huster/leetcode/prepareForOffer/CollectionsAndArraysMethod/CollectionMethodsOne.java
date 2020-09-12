package com.huster.leetcode.prepareForOffer.CollectionsAndArraysMethod;

import java.util.ArrayList;
import java.util.Collections;


/**
 * @author Created by Divo
 * @date 2020/9/9
 * Description:用来测试Collection的一些常见函数
 * Status:unfinished
 */
public class CollectionMethodsOne {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);

        /**
         * 1、reverse方法
         * 反转
         */
        System.out.println("原始数组");
        System.out.println(arrayList);
        Collections.reverse(arrayList);
        System.out.println("Collections.reverse(arrayList):");
        System.out.println(arrayList);

        /**
         * 2、rotate 方法
         * 旋转。当distance为正数时，将list后distance个元素整体移到前面。当distance为负数时，将 list的前distance个元素整体移到后面。
         */
        Collections.rotate(arrayList, 4);
        System.out.println("Collections.rotate(arrayList,4)");
        System.out.println(arrayList);

        /**
         * 3、shuffle（洗牌）方法
         * 随机排序
         */
        Collections.shuffle(arrayList);
        System.out.println("Collections.shuffle(arrayList)");
        System.out.println(arrayList);


        /**
         * 4、sort方法
         * 5、sort  定制排序，由Comparator控制排序逻辑
         */
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList)");
        System.out.println(arrayList);

        Collections.sort(arrayList, (o1, o2) -> {
            return o2 - o1; //降序
        });
        System.out.println("自定义排序后：");
        System.out.println(arrayList);

        /**
         * 6、swap方法
         * 交换两个索引位置的元素
         */
        Collections.swap(arrayList, 0, 3);
        System.out.println(arrayList);

    }
}
