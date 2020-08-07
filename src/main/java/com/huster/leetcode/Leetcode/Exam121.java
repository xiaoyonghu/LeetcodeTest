package com.huster.leetcode.Leetcode;

/**
 * @author Created by Divo
 * @date 2020/8/3
 * Description:Exam94 121 买卖股票的最佳时机 K=1
 * Status:finished
 */
public class Exam121 {
    public int maxProfit(int[] prices) {
       ///遍历所有的，找到最大差值即可
        if (prices.length == 0 || prices ==null)
            return 0;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i])
                minPrice = prices[i];
            else if (prices[i] - minPrice > maxProfit)
                maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}
