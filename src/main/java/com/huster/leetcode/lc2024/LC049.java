package com.huster.leetcode.lc2024;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Syong
 * @version 1.0
 * @date 2024/12/24 21:07
 * @Desc 字母异位数分组
 */
public class LC049 {
    public static void main(String[] args) {
        String[] strList = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strList);
        lists.forEach(x->{
            int len = x.size();
            for (int i = 0; i < len; i++) {
                System.out.print(x.get(i) + " : ");
            }
            System.out.println();
        });

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
//        List<List<String>> resList = new ArrayList<>();
        for (String str : strs){
            char[] charStr = str.toCharArray();
            Arrays.sort(charStr);
            String sortStr = new String(charStr);
            List<String> list = map.getOrDefault(sortStr, new ArrayList<>());
            list.add(str);
            map.put(sortStr, list);
        }
        //这里居然影响性能
//        map.forEach((k, v) -> {
//            resList.add(v);
//        });
        return new ArrayList<>(map.values());
    }

    // 效率不高
    @Deprecated
    public static List<List<String>> groupAnagrams2222(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> resList = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String sortStr = Arrays
                    .stream(strs[i].split("")).sorted().collect(Collectors.joining(""));
            List<String> orDefault = map.getOrDefault(sortStr, new ArrayList<>());
            orDefault.add(strs[i]);
            map.put(sortStr, orDefault);
        }
        map.forEach((k, v) -> {
            resList.add(v);
        });
        return resList;
    }

    /**
     * 这样写的话，same函数实现不了
     **/
    public static List<List<String>> groupAnagrams1111(String[] strs) {
        // 1、双层for，使用一个数组来记录已经存储过的i TimeConsume O(len*2 * n)
        int len = strs.length;
        int[] visited = new int[len];
        List<List<String>> resList = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            visited[i] = 0;
        }
        for (int i = 0; i < len - 1; i++) {
            if (visited[i] == 1) continue;
            List<String> res = new ArrayList<>();
            visited[i] = 1;
            res.add(strs[i]);
            for (int j = i + 1; j < len; j++) {
                if (visited[j] == 1) continue;
                if (isSame(strs[i], strs[j])) {
                    visited[j] = 1;
                    res.add(strs[j]);
                }
            }
            resList.add(res);
        }
        if (visited[len - 1] == 0) {
            resList.add(Arrays.asList(strs[len - 1]));
        }
        return resList;
    }

    /**
     * @Author Syong
     * @Description  比较2个字符串是否一样  这种写法太辣鸡了(超时)
     **/
    @Deprecated
    private static boolean isSame(String str1, String str2) {
        int lenOne = str1.length();
        int lenTwo = str2.length();
        if (lenOne != lenTwo) return false;

        int[] countOne = new int[26];
        StringBuffer sb1= new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < lenOne; i++) {
            countOne[str1.charAt(i) - 'a'] ++ ;
        }
        for (int i = 0; i < 26; i++) {
            if (countOne[i] > 0){
                char orChar = (char) ('a' + i);
                sb1.append(orChar).append(countOne[i]);
            }
        }

        int[] countTwo = new int[26];
        for (int i = 0; i < lenTwo; i++) {
            countTwo[str2.charAt(i) - 'a'] ++ ;
        }
        for (int i = 0; i < 26; i++) {
            if (countTwo[i] > 0){
                char orChar = (char) ('a' + i);
                sb2.append(orChar).append(countTwo[i]);
            }
        }
        return sb1.toString().equals(sb2.toString());
    }
}
