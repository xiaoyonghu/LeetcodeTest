package com.huster.leetcode.PartitionFour;

/**
 * @author Created by Divo
 * @date 2020/4/9
 * Description:把数字翻译成字符串
 *  这一部分的知识需要补一补（看视频，看极客时间算法通关40讲）
 *  递归（从前向后）和动态规划（从后向前）
 * Status:new
 */
public class test46 {
    public static void main(String[] args) {
        test46 t=new test46();
        System.out.println(t.numDecodings("12258"));
    }
    public int numDecodings(String s){
        if (s==null || s.length()==0)
            return 0;
        return DynamicPlan(s);
    }
    /**
     * 先采用递归
     */
//    public int digui(String s,int start){
//        //1、先写终止条件
//        if(start == s.length())//说明此时已经算做成功一个了
//            return 1;
//        if (s.charAt(start)=='0')//从0开始的数不存在
//            return 0;

           //2、再写方程公式
//        //               自己与自己组      自己与后面一个组队
//        //digui(s,start)=digui(s,start+1)+dugui(s,start+2)
//        int ans1=digui(s,start+1);
//        int ans2=0;
//        if (start<s.length()-1){
//            int shiwei=s.charAt(start)-'0';
//            int gewei=s.charAt(start+1)-'0';
//            if ((shiwei*10+gewei)<=26){
//                ans2=digui(s,start+2);
//            }
//        }
            //3、再写返回值
//        return ans1+ans2;
//    }

    /***
     * 采用动态规划来做，自己多多学习
     * num[i]=0  dp[i]=0
     * num[i]+num[i+1]<=26 dp[i]=dp[i+1]+dp[i+2]
     *          不然        dp[i]=dp[i+1]
     */
    public int DynamicPlan(String s){
        int n=s.length();
        int[] dp=new int[n+1];  //为什么数字长度为n+1，不需要将最后一个6单独处理  很是懵逼
        dp[n]=1;
        if (s.charAt(n-1)=='0'){ //处理最后一个元素
            dp[n-1]=0;
        }else {
            dp[n-1]=1;
        }
        for (int i = n-2; i >=0 ; i--) {
            if (s.charAt(i)=='0'){
                dp[i]=0;
                continue;
            }
            if ((s.charAt(i)-'0')*10+(s.charAt(i+1)-'0')<=26){
                dp[i]=dp[i+1]+dp[i+2];
            }else {
                dp[i]=dp[i+1];
            }
        }
        return dp[0];
    }
}
