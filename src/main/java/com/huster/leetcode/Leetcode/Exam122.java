package com.huster.leetcode.Leetcode;

/**
 * @author Yongshao
 * @Date 2022/9/4
 * Description: 买卖股票最佳时机 II (K=任意次)
 * <p>
 * ref：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class Exam122 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null) return 0;
        //通用模板dp[n][k][j]  n =day,k= num of sell or buy, j=num of stock

        int len = prices.length;
        int[][] dp = new int[len][2];

        //数组初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        //状态转移方程
        for (int i = 1; i < len; i++) {
                                //不动          //出售
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}
