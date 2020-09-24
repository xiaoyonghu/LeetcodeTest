package com.huster.leetcode.prepareForOffer.search;

import java.util.Arrays;

/**
 * @author Created by Divo
 * @date 2020/9/18
 * Description:To Do
 * Status:new
 */
public class kuaiPai {

    public static void quickSort(int[] L) {
        QuickSort(L, 0, L.length - 1);
    }

    public static void QuickSort(int[] L, int low, int high) {
        int pivot;
        if (low < high) {
            //将L[low,high]一分为二,算出枢轴值pivot,该值得位置固定,不用再变化
            pivot = partition(L, low, high);

            //对两边的数组分别排序
            QuickSort(L, low, pivot - 1);
            QuickSort(L, pivot + 1, high);
        }
    }

    private static int partition(int[] L, int l, int r) {
        int p = L[l];//以最左边的为基准
        int i = l, j = r + 1;
        while (true) {
            while (i != r && L[++i] < p) ;//找到一个大于等于p,注意条件i!=r
            while (j != l && L[--j] > p) ;//找到一个小于等于p,注意条件j!=l
            if (i >= j)
                break;
            swap(L, i, j);
        }
        swap(L, l, j);//注意这里是l和j的位置交换
        return j;
    }

    private static void swap(int[] L, int i, int j) {
        int t = L[i];
        L[i] = L[j];
        L[j] = t;
    }

    public static void main(String[] args) {
        int[] L = {9, 7, 43, 2, 4, 5, 100};
        System.out.println(Arrays.toString(L));
        quickSort(L);
        System.out.println(Arrays.toString(L));
    }


//    private static int partition(int[] arr, int low, int high) {
//        //指定左指针i和右指针j
//        int i = low;
//        int j= high;
//
//        //将第一个数作为基准值。挖坑
//        int x = arr[low];
//
//        //使用循环实现分区操作
//        while(i<j){//5  8
//            //1.从右向左移动j，找到第一个小于基准值的值 arr[j]
//            while(arr[j]>=x && i<j){
//                j--;
//            }
//            //2.将右侧找到小于基准数的值加入到左边的（坑）位置， 左指针想中间移动一个位置i++
//            if(i<j){
//                arr[i] = arr[j];
//                i++;
//            }
//            //3.从左向右移动i，找到第一个大于等于基准值的值 arr[i]
//            while(arr[i]<x && i<j){
//                i++;
//            }
//            //4.将左侧找到的打印等于基准值的值加入到右边的坑中，右指针向中间移动一个位置 j--
//            if(i<j){
//                arr[j] = arr[i];
//                j--;
//            }
//        }
//
//        //使用基准值填坑，这就是基准值的最终位置
//        arr[i] = x;//arr[j] = y;
//        //返回基准值的位置索引
//        return i; //return j;
//    }
//    private static void quickSort(int[] arr, int low, int high) {//???递归何时结束
//        if(low < high){
//            //分区操作，将一个数组分成两个分区，返回分区界限索引
//            int index = partition(arr,low,high);
//            //对左分区进行快排
//            quickSort(arr,low,index-1);
//            //对右分区进行快排
//            quickSort(arr,index+1,high);
//        }
//
//    }
//
//    public static void quickSort(int[] arr) {
//        int low = 0;
//        int high = arr.length-1;
//        quickSort(arr,low,high);
//    }
//
//    public static void main(String[] args) {
//        //给出无序数组
//        int arr[] = {72,6,57,88,60,42,83,73,48,85};
//
//        //输出无序数组
//        System.out.println(Arrays.toString(arr));
//        //快速排序
//        quickSort(arr);
//        //partition(arr,0,arr.length-1);
//        //输出有序数组
//        System.out.println(Arrays.toString(arr));
//    }

}
