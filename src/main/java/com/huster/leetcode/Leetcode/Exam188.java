package com.huster.leetcode.Leetcode;

/**
 * @author Yongshao
 * @Date 2022/9/4
 * Description: 买卖股票的最佳时机 IV
 * <p>
 * 交易次数K次  (同时只能持有一只股票)
 */
public class Exam188 {

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || prices == null) return 0;

        int n = prices.length;

        int[][][] dp = new int[n][k + 1][2];
        // 初始化
        // num of sell
        for (int i = 0; i <= k; i++) {
            // whether hold stock
            for (int j = 0; j < 2; j++) {
                dp[0][i][j] = -prices[0];
            }
        }
        dp[0][0][0] = 0;


        // 状态转移方程
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0) {
                    dp[i][0][0] = dp[i - 1][0][0];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }

        int maxProfit = 0;
        for (int i = 0; i <= k; i++) {
            if (dp[n - 1][i][0] > maxProfit) {
                maxProfit = dp[n - 1][i][0];
            }
        }

        return maxProfit;
    }

}
