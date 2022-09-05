package com.huster.leetcode.SwordToOffer.PartitionSix;

/**
 * @author Yongshao
 * @Date 2022/9/4
 * Description:股票的最大利润
 * 这里键指offer的63与lc的122一样的，属于easy
 * 这里就是K=1
 * <p>
 * lc 122：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/submissions/
 */
public class Test63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null) return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            // 找到一个小的
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
