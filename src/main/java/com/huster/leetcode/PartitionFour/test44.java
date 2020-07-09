package com.huster.leetcode.PartitionFour;

/**
 * @author Created by Divo
 * @date 2020/4/8
 * Description:数字序列中某一位的数字  剑指offer44
 * Status:这一题有点蹊跷，刚刚开始想的时候有点累
 */
public class test44 {

    public static void main(String[] args) {
        test44 e=new test44();
        System.out.println(e.findNthDigit(100));
    }
    public int findNthDigit(int n) {
        if (n<10)
            return n;
        int digit=1;
        int count=0;//用来统计
        while (true){
            count=countOfInteger(digit);
            if (n<count) break;
            n=n-count;
            digit++;
        }
        int resultSum=getBeginOfDigit(digit)+(n/digit);//该在那个数中
        int shiftNum=n%digit; //在这个数中的偏移量

        return  String.valueOf(resultSum).charAt(shiftNum)-'0';

    }
    public int getBeginOfDigit(int digit){
        return (int) Math.pow(10,digit-1);
    }

    /**
     * 上次在这里耽搁了很久就是忘了加*digit
     * @param digit
     * @return
     */
    public int countOfInteger(int digit){
        if (digit==1)
            return 10;
        return (int) (Math.pow(10,digit-1)*9*digit);
    }

}
