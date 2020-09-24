package com.huster.leetcode.prepareForOffer.search;

/**
 * @author Created by Divo
 * @date 2020/9/18
 * Description:To Do
 * Status:new
 */
public class binarySearch {
    public int BinarySearch(int[] array,int target){
        int left =0;
        int right = array.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (array[mid] == target){
                return mid;
            }else if(array[mid]< target){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        return -1;
    }

    public int BinarySearchLeft(int[] array,int target){
        int left =0;
        int right = array.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if (array[mid] == target){
                right = mid -1;
            }else if(array[mid]< target){
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        if (left >=array.length || array[left] != target){
            return -1;
        }
        return left;
    }
}
