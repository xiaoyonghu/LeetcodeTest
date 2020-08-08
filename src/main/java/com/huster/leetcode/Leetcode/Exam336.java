package com.huster.leetcode.Leetcode;

import java.util.*;

/**
 * @author Created by Divo
 * @date 2020/8/7
 * Description:lc 336 回文对
 * Status:finished
 */
public class Exam336 {
    /**
     * 1、暴力他不香嘛？
     * 暴力的解法 时间复杂度O(n*2 * m)
     */
//    public List<List<Integer>> palindromePairs(String[] words) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (words.length == 0)
//            return res;
//        for (int i = 0; i < words.length; i++) {
//            for (int j = i + 1; j < words.length; j++) {
//                if (isPalindromePairs(words[i], words[j]))
//                    res.add(Arrays.asList(i, j));
//                if (isPalindromePairs(words[j], words[i]))
//                    res.add(Arrays.asList(j, i));
//            }
//        }
//        return res;
//    }
//
//    private boolean isPalindromePairs(String w1, String w2) {
//        char[] chars = (w1 + w2).toCharArray();
//        int low = 0, high = chars.length - 1;
//        while (low <= high) {
//            if (chars[low] != chars[high]) return false;
//            low++;
//            high--;
//        }
//        return true;
//    }
//
//
//    class Node {
//        int[] ch = new int[26];
//        int flag;
//
//        public Node() {
//            flag = -1;
//        }
//    }
//

    /**
     * 2、使用字典序列来实现
     * @param words
     * @return
     */
    /**
     public List<List<Integer>> palindromePairs1(String[] words) {
     tree.add(new Node());
     int n = words.length;
     for (int i = 0; i < n; i++) {
     insert(words[i], i);
     }
     List<List<Integer>> ret = new ArrayList<List<Integer>>();
     for (int i = 0; i < n; i++) {
     int m = words[i].length();
     for (int j = 0; j <= m; j++) {
     if (isPalindrome(words[i], j, m - 1)) {
     int leftId = findWord(words[i], 0, j - 1);
     if (leftId != -1 && leftId != i) {
     ret.add(Arrays.asList(i, leftId));
     }
     }
     if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
     int rightId = findWord(words[i], j, m - 1);
     if (rightId != -1 && rightId != i) {
     ret.add(Arrays.asList(rightId, i));
     }
     }
     }
     }
     return ret;
     }

     public void insert(String s, int id) {
     int len = s.length(), add = 0;
     for (int i = 0; i < len; i++) {
     int x = s.charAt(i) - 'a';
     if (tree.get(add).ch[x] == 0) {
     tree.add(new Node());
     tree.get(add).ch[x] = tree.size() - 1;
     }
     add = tree.get(add).ch[x];
     }
     tree.get(add).flag = id;
     }

     public boolean isPalindrome(String s, int left, int right) {
     int len = right - left + 1;
     for (int i = 0; i < len / 2; i++) {
     if (s.charAt(left + i) != s.charAt(right - i)) {
     return false;
     }
     }
     return true;
     }

     public int findWord(String s, int left, int right) {
     int add = 0;
     for (int i = right; i >= left; i--) {
     int x = s.charAt(i) - 'a';
     if (tree.get(add).ch[x] == 0) {
     return -1;
     }
     add = tree.get(add).ch[x];
     }
     return tree.get(add).flag;
     }
     */


    /**
     * 3、使用hash表，这个最好理解
     */
    List<String> listReverse = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    HashMap<String, Integer> indexMap = new HashMap<>();

    public List<List<Integer>> palindromePairs1(String[] words) {
        int n = words.length;
        for (String s : words) {
            listReverse.add(new StringBuffer(s).reverse().toString());
        }
        for (int i = 0; i < n; i++) {
            indexMap.put(listReverse.get(i), i);//存储的是以及翻转了的，后面可以直接匹配
        }
        //最外层的循环 Time:O(N)
        for (int i = 0; i < n; i++) {
            String s = words[i];
            int len = words[i].length();
            if (len == 0)
                continue;
            //到了j这个点 Time：O(M)
            for (int j = 0; j <= len; j++) {
                //左边的为匹配翻转，右边的为回文串  Time：O(M)
                if (isPalindromePairs(s, j, len - 1)) {
                    int leftId = find(s, 0, j - 1);
                    if (leftId != -1 && leftId != i)
                        res.add(Arrays.asList(i, leftId));
                }
                //左边的为回文串，右边的为匹配翻转
                if (j != 0 && isPalindromePairs(s, 0, j - 1)) {
                    int rightId = find(s, j, len - 1);
                    if (rightId != -1 && rightId != i)
                        res.add(Arrays.asList(rightId, i));
                }
            }
        }
        return res;
    }

    private int find(String s, int left, int right) {
        return indexMap.getOrDefault(s.substring(left, right + 1), -1);
    }

    public boolean isPalindromePairs(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) return false;
        }
        return true;
    }
}

