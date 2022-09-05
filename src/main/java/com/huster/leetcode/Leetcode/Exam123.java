package com.huster.leetcode.Leetcode;

/**
 * @author Yongshao
 * @Date 2022/9/4
 * Description: 买卖股票的最佳时机 III  （K=2）
 * ref: https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class Exam123 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null) return 0;

        int K = 2, D = prices.length;

        //初始状态的定义
        //[][k][]当买入的话不计数，卖出才+1
        int[][][] maxProfit = new int[D][K + 1][2];
        maxProfit[0][0][0] = 0;
        maxProfit[0][0][1] = -prices[0];

//        maxProfit[0][1][0] = -Integer.MAX_VALUE;
//        maxProfit[0][1][1] = -Integer.MAX_VALUE;
//
//        maxProfit[0][2][0] = -Integer.MAX_VALUE;
//        maxProfit[0][2][1] = -Integer.MAX_VALUE;

        maxProfit[0][1][0] = -prices[0];
        maxProfit[0][1][1] = -prices[0];

        maxProfit[0][2][0] = -prices[0];
        maxProfit[0][2][1] = -prices[0];

        for (int i = 1; i < D; i++) {
            //状态转移方程
            maxProfit[i][0][0] = maxProfit[i - 1][0][0];
            maxProfit[i][0][1] = Math.max(maxProfit[i - 1][0][1], maxProfit[i - 1][0][0] - prices[i]); //买入

            maxProfit[i][1][0] = Math.max(maxProfit[i - 1][1][0], maxProfit[i - 1][0][1] + prices[i]); //卖出
            maxProfit[i][1][1] = Math.max(maxProfit[i - 1][1][1], maxProfit[i - 1][1][0] - prices[i]); //买入

            maxProfit[i][2][0] = Math.max(maxProfit[i - 1][2][0], maxProfit[i - 1][1][1] + prices[i]); //卖出

            // 这种状态不存在
            // maxProfit[i][2][1]=;
        }

        //因为股票不存在负的，所以只有卖完才是利润最大
        return Math.max(Math.max(maxProfit[D - 1][0][0], maxProfit[D - 1][1][0]), maxProfit[D - 1][2][0]);
    }
}
