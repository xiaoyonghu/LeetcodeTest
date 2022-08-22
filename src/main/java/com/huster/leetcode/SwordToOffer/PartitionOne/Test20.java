package com.huster.leetcode.SwordToOffer.PartitionOne;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yongshao
 * @Date 2022/8/21
 * Description: 表示数值的字符串
 * 状态机
 * 无聊的题目
 */
public class Test20 {
    public boolean isNumber(String s) {
        //状态转移方程
        Map[] states = {
                new HashMap<>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap<>() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap<>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap<>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap<>() {{ put('d', 3); }},                                        // 4.
                new HashMap<>() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap<>() {{ put('d', 7); }},                                        // 6.
                new HashMap<>() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap<>() {{ put(' ', 8); }}                                         // 8.
        };
        int p = 0; //开始的状态
        char t;
        //遍历每一个字符
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') t = 'd';
            else if (c == '+' || c == '-') t = 's';
            else if (c == '.' || c == ' ') t = c;  //赋值为自身
            else if (c == 'e' || c == 'E') t = 'e';
            else t = '?';
            if (!states[p].containsKey(t)) return false;//是否包含刚刚状态
            p = (int) states[p].get(t);  //转换到下一个状态
        }

        return p == 2 || p == 3 || p == 7 || p == 8;
    }

    public static void main(String[] args) {

    }
}
