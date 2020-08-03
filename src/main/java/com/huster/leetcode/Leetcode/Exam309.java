package com.huster.leetcode.Leetcode;

/**
 * @author Created by Divo
 * @date 2020/8/3
 * Description: lc 309 最佳买卖股票时机含冷冻期（只需要额外的一维即可） 但是K=1
 * Status:finished
 */
public class Exam309 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null)
            return 0;
        //1、dp[i]:第i天介绍后的累计最大利益
        // 定义DP[i][0] : 持股票
        // DP[i][1]: 不持有股票，并且处于冷冻期（i+1不能买）
        // dp[i][2]: 不持有股票，并且不处于冷冻
        int[][] dp =new int[prices.length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1; i < prices.length; i++) {
            //dp状态转移方程
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);//啥也不干、买
            dp[i][1] = dp[i-1][0] + prices[i];//卖出
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][1]);//啥也不干、消除前一天的冷冻期
        }
        //最大值肯定是最后一天，并且手中不持有股票
        return Math.max(dp[prices.length-1][1],dp[prices.length-1][2]);

    }
    //常见的优化
    public int maxProfit1(int[] prices) {
        if (prices.length == 0 || prices == null)
            return 0;

        int holdStock = -prices[0];
        int Frozen = 0;
        int notFrozen = 0;

        for (int i = 1; i < prices.length; i++) {
            //dp状态转移方程
            int f1 = Math.max(holdStock,notFrozen-prices[i]);//啥也不干、买
            int f2 = holdStock + prices[i];//卖出
            int f3 = Math.max(notFrozen,Frozen);//啥也不干、消除前一天的冷冻期
            holdStock = f1;
            Frozen = f2;
            notFrozen = f3;
        }
        //最大值肯定是最后一天，并且手中不持有股票
        return Math.max(Frozen,notFrozen);
    }
}
