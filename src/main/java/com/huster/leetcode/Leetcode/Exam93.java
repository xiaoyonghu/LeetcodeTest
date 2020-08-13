package com.huster.leetcode.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Divo
 * @date 2020/8/9
 * Description:lc 93 复原IP地址
 * 回溯  感觉有思路，但是就是写不出来
 * Status:finished
 */
public class Exam93 {
    static final int SEGMENT = 4;
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        List<Integer> list = new LinkedList<>();
        dfs(s, list, 0);
        return res;
    }

    private void dfs(String s, List<Integer> list, int start) {
        //1、满足结束条件
        if (list.size() == SEGMENT) {
            if (start == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < SEGMENT; i++) {
                    sb.append(list.get(i));
                    if (i != SEGMENT - 1)
                        sb.append(".");
                }
                res.add(sb.toString());
            }
            return;
        }
        if (list.size() == SEGMENT && start < s.length())
            return;
        //2、选择列表
        for (int len = 1; len <= 3; len++) {
            if ((start + len - 1) >= s.length()) //已经溢出数组范围
                return;
            if (len != 1 && s.charAt(start) == '0')//0X,0XX排除
                return;
            int addr = Integer.parseInt(s.substring(start, start + len));
            if (len == 3) {
                if (addr > 255)
                    return;
            }
            //2.1、做选择
            list.add(addr);
            //2.2、递归到下一层
            dfs(s, list, start + len);
            //2.3、撤销选择
            list.remove(list.size() - 1);
        }
    }
}
