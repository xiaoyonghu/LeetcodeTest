package com.huster.leetcode.Leetcode;

import java.util.Arrays;

/**
 * @author Created by Divo
 * @date 2020/8/31
 * Description:lc 354 俄罗斯套娃信封问题
 * 思路：  先对宽度 w 进行<code>升序</code>排序，如果遇到 w 相同的情况，则按照高度 h <code>降序<code/>排序。
 * 之后把所有的 h 作为一个数组，在这个数组上计算 LIS<Code>leetCode300<Code/> 的长度就是答案。
 * Status:finished
 *
 * <href>https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/dong-tai-gui-hua-she-ji-zui-chang-di-zeng-zi-xu-lie</href>
 */
public class Exam354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;//行数                   //逆序           //升序
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengtOfLIS(height);
    }

    private int lengtOfLIS(int[] height) {
        int[] tails = new int[height.length];
        int size = 0;
        for (int x : height) {
            int i = Arrays.binarySearch(tails, 0, size, x);
            if (i < 0)
                i = -(i + 1);//这里i的值就为-1
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}
