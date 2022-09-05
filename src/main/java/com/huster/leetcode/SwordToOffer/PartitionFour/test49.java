package com.huster.leetcode.SwordToOffer.PartitionFour;

/**
 * @author Created by Divo
 * @date 2020/4/12
 * Description:求丑数,被2,3,5整除的数
 * <p>
 * 思考：这种题就是需要刷就好了！！！
 * 3个指正，然后比较每个乘以2,3,5,然后得到的最小值，
 * 如果指正对的值<= min 那就移动相应的指针
 */
public class test49 {
    public int GetUglyNumber_Solution(int index) {
        //1,2,3,4,5,6都是丑数
        if (index <= 6)
            return index;
        int p2 = 0, p3 = 0, p5 = 0;
        int[] dp = new int[index];
        dp[0] = 1;
        for (int i = 1; i < index; i++) {
            int next2 = dp[p2] * 2, next3 = dp[p3] * 3, next5 = dp[p5] * 5;
            dp[i] = Math.min(next2, Math.min(next3, next5));
            //这三个if有可能进入一个或者多个，进入多个是三个队列头最小的数有多个的情况
            //可以参看牛客上别人画的图
            if (next2 <= dp[i])
                p2++;
            if (next3 <= dp[i])
                p3++;
            if (next5 <= dp[i])
                p5++;
        }
        return dp[index - 1];
    }


    public int nthUglyNumber(int n) {
        if (n <= 6) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int next2 = dp[p2] * 2, next3 = dp[p3] * 3, next5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(next2, next3), next5);
            if (next2 <= dp[i]) p2++;
            if (next3 <= dp[i]) p3++;
            if (next5 <= dp[i]) p5++;
        }
        return dp[n - 1];
    }

}
