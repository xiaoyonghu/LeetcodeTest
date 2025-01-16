package com.huster.leetcode.lc2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/16 21:29
 * @Desc 合并区间
 */
public class LC056 {
    public static void main(String[] args) {
//        int[][] intervals = {
//                {1, 3},
//                {2, 6},
//                {8, 10},
//                {15, 18}
//        };
        int[][] intervals = {
                {1, 4},
                {4, 5},
        };
        LC056 lc056 = new LC056();
        int[][] res = lc056.merge(intervals);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i][0] + ",");
            System.out.print(res[i][1]);
            System.out.println();
        }

    }

    //
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 1) return intervals;
        List<List<Integer>> res = new ArrayList<>();

        // 使用自定义比较器对二维数组进行排序
        // 先对数组第一个值进行升序排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]); // 比较第一列元素
            }
        });

        for (int i = 0, j = 1; j < len; i++, j++) {
            if (canMerge(intervals[i], intervals[j])) {
                // 更新 intervals[j]
                doMerge(intervals[i], intervals[j]);
            } else {
                // 将intervals[i]加入结果
                res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            }
            // 加上最后一组
            if (j == len - 1) {
                res.add(Arrays.asList(intervals[j][0], intervals[j][1]));
            }
        }
        int resLen = res.size();
        int[][] resInts = new int[resLen][2];
        for (int i = 0; i < resLen; i++) {
            List<Integer> list = res.get(i);
            resInts[i][0] = list.get(0);
            resInts[i][1] = list.get(1);
        }
        return resInts;
    }

    private void doMerge(int[] a, int[] b) {
        b[0] = Math.min(b[0], a[0]);
        b[1] = Math.max(b[1], a[1]);
    }

    // 是否能有交集
    private boolean canMerge(int[] a, int[] b) {
        if (b[0] > a[1]) return false;
        return true;
    }

}
