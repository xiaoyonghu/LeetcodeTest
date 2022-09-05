package com.huster.leetcode.SwordToOffer.PartitionSix;

import java.util.Arrays;

/**
 * @author Yongshao
 * @Date 2022/9/4
 * Description:n个筛子的点数
 * <p>
 * 参考的别人的思路：大开眼界
 */
public class Test60 {

    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);

        for (int i = 2; i <= n; i++) {
            //个数为(6n-n+1)， 合的范围为【n,6n】
            double[] transTmp = new double[5 * i + 1];

            //原始的dp的每一个对后续的贡献度
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    //算1-6每个值对下一个的贡献度
                    transTmp[j + k] += (dp[j] / 6.0);
                }
            }
            dp = transTmp;
        }
        return dp;
    }

}
