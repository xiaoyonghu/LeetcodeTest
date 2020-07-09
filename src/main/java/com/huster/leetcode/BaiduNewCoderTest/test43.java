package com.huster.leetcode.BaiduNewCoderTest;

/**
 * @author Created by Divo
 * @date 2020/4/2
 * Description:1-n个整数中1出现的次数，参考的牛客后面的解答
 * Status:new
 */
public class test43 {

    int count=0;
    public int GetNumberOf1(int n){
        for (int m = 1; m <= n ; m*=10) {
            int a=n/m;//取高位
            int b=n%m;//取低位
            if(a%10==0){
                count += a/10 * m;
            }else if (a % 10 == 1){
                count += a/10*m  + (b+1);
            }else{
                count += (a/10 + 1)*m;
            }
        }
        return count;
    }
}
