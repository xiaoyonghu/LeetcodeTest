package com.huster.leetcode.BaiduNewCoderTest;

/**
 * @author Created by Divo
 * @date 2020/4/1
 * Description: 连续子数组的和
 * Status:new
 */
public class test42 {

    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0 || array== null){
            return 0;
        }
        int nCur=0;  //当前最大值
        int Max_Sum=Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (nCur<=0){
                nCur=array[i];  //不用加一个最小数
            }else {
                nCur += array[i];
            }
            if (Max_Sum < nCur){
                Max_Sum=nCur;
            }
        }
        return  Max_Sum;
    }
}
