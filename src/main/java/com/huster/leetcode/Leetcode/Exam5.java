package com.huster.leetcode.Leetcode;

import java.util.Arrays;

import static java.util.Arrays.fill;

/**
 * @author Created by Divo
 * @date 2020/7/26
 * Description:最长回文子串
 * Status:finished
 */
public class Exam5 {

    /**
     *  方法一  中心扩散
     *  时间复杂度为O(N*2)  枚举是n,然后向2边扩散也是n
     public String longestPalindrome(String s) {
     int[] arr = new int[2];
     char[] chars = s.toCharArray();
     for (int i = 0; i < s.length(); i++) {
     i = findLPSBasedI(chars,i,arr);
     }
     //include  exclusive
     return s.substring(arr[0],arr[1]+1);
     }
     int findLPSBasedI(char[] chars,int low,int[] arr){
     //1、找跟i节点相同的最右边的index
     int high = low;
     while ( high < chars.length -1 && (chars[high + 1] == chars[low])){
     high++;
     }
     //ans的值为最后一个与low节点所对应的值相等的节点,可以加快主循环的速度
     int ans = high;
     //以low high为中间部分 向2遍扩散
     while (low >0 && (high < chars.length-1) && chars[low-1] == chars[high+1]){
     low--;
     high++;
     }
     if ((arr[1] - arr[0]) < (high - low)){
     arr[0] = low;
     arr[1] = high;
     }
     return ans;
     }
     */

    /**
     * @param s
     * @return 方法二 采用dp
     * public String longestPalindrome(String s) {
     * int len = s.length();
     * if (len < 2) {
     * return s;
     * }
     * <p>
     * boolean[][] dp = new boolean[len][len];
     * for (int i = 0; i < len; i++) {
     * Arrays.fill(dp[i], false);
     * }
     * <p>
     * // 初始化
     * for (int i = 0; i < len; i++) {
     * dp[i][i] = true;
     * }
     * <p>
     * <p>
     * char[] charArray = s.toCharArray();
     * int maxLen = 1;
     * int start = 0;
     * <p>
     * //时间复杂度为O(N*2)
     * for (int j = 1; j < len; j++) {
     * // 只有下面这一行和「参考代码 2」不同，i 正着写、倒过来写都行，因为子串都有参考值
     * for (int i = j - 1; i >= 0; i--) {
     * <p>
     * if (charArray[i] == charArray[j]) {
     * //里面的子串长度小于2了 除了i,j节点(i,j).length()<2
     * if (j - i < 3) {
     * dp[i][j] = true;
     * } else {
     * //里面的子串长度大于等于2
     * //状态转移方程，等于去掉首尾
     * dp[i][j] = dp[i + 1][j - 1];
     * }
     * } else {
     * //首尾不等，直接GG
     * dp[i][j] = false;
     * }
     * <p>
     * // 只要 dp[i][j] == true 成立，就表示子串 s[i, j] 是回文，此时记录回文长度和起始位置
     * if (dp[i][j]) {
     * int curLen = j - i + 1;
     * if (curLen > maxLen) {
     * maxLen = curLen;
     * start = i;
     * }
     * }
     * }
     * }
     * return s.substring(start, start + maxLen);
     * }
     */

    /**
     * 解法3 采用Manacher算法  看的我吐了、
     * 时间复杂度为O(N)
     */
    public String longestPalindrome(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        // 得到预处理字符串
        String str = addBoundaries(s, '#');
        // 新字符串的长度
        int sLen = 2 * len + 1;

        // 数组 p 记录了扫描过的回文子串的信息
        int[] p = new int[sLen];

        // 双指针，它们是一一对应的，须同时更新
        int maxRight = 0;
        int center = 0;

        // 当前遍历的中心最大扩散步数，其值等于原始字符串的最长回文子串的长度
        int maxLen = 1;
        // 原始字符串的最长回文子串的起始位置，与 maxLen 必须同时更新
        int start = 0;

        //下面的Manacher算法的代码都是一样写
        for (int i = 0; i < sLen; i++) {
            if (i < maxRight) {
                int mirror = 2 * center - i;
                // 这一行代码是 Manacher 算法的关键所在，要结合图形来理解
                p[i] = Math.min(maxRight - i, p[mirror]);
            }

            // 下一次尝试扩散的左右起点，能扩散的步数直接加到 p[i] 中
            int left = i - (1 + p[i]);
            int right = i + (1 + p[i]);

            // left >= 0 && right < sLen 保证不越界
            // str.charAt(left) == str.charAt(right) 表示可以扩散 1 次
            while (left >= 0 && right < sLen && str.charAt(left) == str.charAt(right)) {
                p[i]++;
                left--;
                right++;

            }
            // 根据 maxRight 的定义，它是遍历过的 i 的 i + p[i] 的最大者
            // 如果 maxRight 的值越大，进入上面 i < maxRight 的判断的可能性就越大，这样就可以重复利用之前判断过的回文信息了
            if (i + p[i] > maxRight) {
                // maxRight 和 center 需要同时更新
                maxRight = i + p[i];
                center = i;
            }
            if (p[i] > maxLen) {
                // 记录最长回文子串的长度和相应它在原始字符串中的起点
                maxLen = p[i];
                start = (i - maxLen) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }


    private String addBoundaries(String s, char divide) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        if (s.indexOf(divide) != -1) {
            throw new IllegalArgumentException("参数错误，您传递的分割字符，在输入字符串中存在！");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(divide);
            stringBuilder.append(s.charAt(i));
        }
        stringBuilder.append(divide);
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        String s = "cbbd";
        Exam5 exam5 = new Exam5();
        System.out.println(exam5.longestPalindrome(s));
    }
}
