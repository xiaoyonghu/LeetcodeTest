package com.huster.leetcode.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Divo
 * @date 2020/8/6
 * Description:lc 22 括号生成
 * Status:finished
 */
public class Exam22 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        gP(list, "", 0, 0, n);
        return list;
    }

    private void gP(List<String> list, String s, int leftUsed, int rightUsed, int n) {
        if (leftUsed == n && rightUsed == n)
            list.add(s);

        //使用左括号
        if (leftUsed < n)
            gP(list, s + "(", leftUsed + 1, rightUsed, n);

        //左括号比右括号使用的多，且右括号的使用量小于n
        if (leftUsed > rightUsed && rightUsed < n)
            gP(list, s + ")", leftUsed, rightUsed + 1, n);
    }
}
