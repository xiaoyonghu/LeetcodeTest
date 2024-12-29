package com.huster.leetcode.lc2024;


import java.util.*;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/29 14:09
 * @Desc 找出字符串中所有字母异位数
 */
public class LC438 {
    public static void main(String[] args) {
//        String s = "cbaebabacd", p = "abc";
        String s = "aaabb", p = "bb";
        findAnagrams(s, p).stream().forEach(x ->
                System.out.print(x + " ")
        );
    }


    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> resList = new ArrayList<>();
        // 下面的写法是遇到了测试case
        if (sLen < pLen) return resList;
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        // 对于统一需要计数的都用这种字母数字 -'a' 来实现
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sCount,pCount))
            resList.add(0);

        // 以j为滑动窗口的左边
        for (int j = 1; j < sLen - pLen + 1; j++) {
            sCount[s.charAt(j - 1) - 'a']--;
            sCount[s.charAt(j + pLen - 1) - 'a']++;
            if (Arrays.equals(sCount, pCount))
                resList.add(j);
        }
        return resList;
    }


    /**
     * @Author Syong
     * @Description 下面的写法超时了，过不了
     **/
    @Deprecated
    public static List<Integer> findAnagramsDeprecated(String s, String p) {
        // 使用滑动窗口 （长度为p.length）,
        // TimeConsume(n * m* log(m))，spaceConsume
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> resList = new ArrayList<>();
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < pLen; i++) {
            charSet.add(p.charAt(i));
        }

        for (int i = 0, j = pLen - 1; j < sLen; j++, i++) {
            String subStr = s.substring(i, j + 1);
            if (!charSet.contains(s.charAt(j))) continue;
            if (isAnagram(subStr, p)) resList.add(i);
        }
        return resList;
    }

    /**
     * @Author Syong
     * @Description 判断2个字符串是否为字母异位数
     **/
    @Deprecated
    private static boolean isAnagram(String subStr, String p) {
        if (subStr.length() != p.length())
            return false;
        char[] charsArray1 = subStr.toCharArray();
        char[] charsArray2 = p.toCharArray();
        Arrays.sort(charsArray1);
        Arrays.sort(charsArray2);
        return Arrays.equals(charsArray1, charsArray2);
    }
}
