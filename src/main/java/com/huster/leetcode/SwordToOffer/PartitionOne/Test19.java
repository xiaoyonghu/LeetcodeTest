package com.huster.leetcode.SwordToOffer.PartitionOne;

/**
 * @author Yongshao
 * @Date 2022/8/18
 * Description:正则表达式匹配
 * 难度比较大，dp
 * <p>
 * ref:https://www.bilibili.com/video/BV1Br4y1v7SA/?spm_id_from=pageDriver&vd_source=374541d659d1bd23a2e3813a5603e91b
 */
public class Test19 {
    public boolean isMatch(String s, String p) {
        int n = s.length() + 1, m = p.length() + 1;
        if (n == 1 && m == 1) {
            return true;
        }
        if (n != 1 && m == 1) {
            return false;
        }
        boolean dp[][] = new boolean[n][m];
        // 初始化
        dp[0][0] = true;
        for (int k = 2; k < m; k += 2) {
            //初始化首行
            dp[0][k] = dp[0][k - 2] && p.charAt(k - 1) == '*';
        }

        //思路是对的，但是坐标转换有问题
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                dp[i][j] = p.charAt(j) == '*' ?
//                        dp[i][j - 2] || (dp[i - 1][j] && ((s.charAt(i) == p.charAt(j - 1)) || p.charAt(j - 1) == '.')) :
//                        dp[i - 1][j - 1] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
//            }
//        }
//        return dp[n][m];


        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = p.charAt(j - 1) == '*' ?
                        dp[i][j - 2] || (dp[i - 1][j] && ((s.charAt(i - 1) == p.charAt(j - 2)) || p.charAt(j - 2) == '.')) :
                        dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {

    }
}
