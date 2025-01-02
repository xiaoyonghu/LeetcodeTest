package com.huster.leetcode.lc2024;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/1 22:17
 * @Desc 编辑距离 DP（多维）
 */
public class LC072 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        // horse -> rorse (将 'h' 替换为 'r')
        // rorse -> rose (删除 'r')
        // rose -> ros (删除 'e')
        // 能换就换，除非长度差（不然就不用插如一个新元素）
    }

    // Commit: 这个题目有点意思
    // 开眼界了
    public static int minDistance(String word1, String word2) {
        int lenWord1 = word1.length();
        int lenWord2 = word2.length();

        // dp[i][j] 表示字符word1的"前i位" 与字符word2的"前j位"匹配
        int[][] dp = new int[lenWord1 + 1][lenWord2 + 1];

        // 初始化
        for (int i = 0; i <= lenWord1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= lenWord2; j++) {
            dp[0][j] = j;
        }

        // 动态转移方程
        for (int i = 1; i <= lenWord1; i++) {
            for (int j = 1; j <= lenWord2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 +
                            Math.min(dp[i][j - 1],   // word1 插入
                                    Math.min(dp[i - 1][j],  // word1 删除
                                            dp[i - 1][j - 1])); //word1 替换
                }
            }
        }

        return dp[lenWord1][lenWord2];
    }
}
