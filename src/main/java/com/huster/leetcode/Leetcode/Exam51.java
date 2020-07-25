package com.huster.leetcode.Leetcode;

/**
 * @author Created by Divo
 * @date 2020/7/20
 * Description:n皇后问题
 * Status:
 *  1、有py的12行代码打印全部
 *  2、下面的这种办法是统计有多少种解法
 */
public class Exam51 {
    static int count=0;
    //统计n皇后有多少种解法
    public void queenCount(int n,int row,int col,int pie,int na){
        //终止条件
        if (row>=n){
            count ++ ;
            //return;
        }else {
            //得到现在可用的列 其中1可用列，0表示没有（注意这里已经倒转过来了）
           int pos= (~(col | pie | na )) & ((1 << n) -1);
           //枚举所有1的位置，然后去放置皇后
           while (pos != 0){
               //取出pos的二进制最后一个1所在位置的值
               int p= pos & (-pos);
               //col | p 将p二进制位1的位置上放皇后
               //(pie | p) << 1 更新pie的下一层不能放的位置，是因为由pie造成的占位在下一行要左移一下；
               //(na | p) << 1 更新na的下一层不能放的位置
               queenCount(n,row+1,col | p,(pie | p) << 1,(pie | p) >> 1);
               //去掉最低位的1
               //pos = pos ^ p;
               pos = pos & (pos -1);
           }
        }
    }
    public static void main(String[] args) {
        Exam51 queen=new Exam51();
        queen.queenCount(8,0,0,0,0);
        System.out.println(count);
        // 32种，我笑了
    }
}
