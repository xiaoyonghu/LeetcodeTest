package com.huster.leetcode.fallHireExam.souGou;


/**
 * @author Created by Divo
 * @date 2020/9/5
 * Description: a b c 其中的2个（相同、不同）都可以换一个别的， abc一组可以换一个奖品
 * 二分法
 * Status:finished
 * see more details check<href>https://www.nowcoder.com/discuss/500271<href/>
 */
public class sougou001 {
    public int numberofprize(int a, int b, int c) {
        int left = min(a, b, c);
        int right = max(a, b, c);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, a, b, c)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    //感觉这个条件看不懂
    private boolean check(int mid, int a, int b, int c) {
        int left = 0;
        if (a >= mid) {
            left += (a - mid);
        } else {
            left -= ((mid - a) * 2);
        }
        if (b >= mid) {
            left += (b - mid);
        } else {
            left -= ((mid - b) * 2);
        }
        if (c >= mid) {
            left += (c - mid);
        } else {
            left -= ((mid - c) * 2);
        }
        return left >= 0;
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {

    }
}
