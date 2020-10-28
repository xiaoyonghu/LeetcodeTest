package com.huster.leetcode.fallHireExam.FiveTongceng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author Created by Divo
 * @date 2020/10/11
 * Description:找出最后的一个节点[去重]
 * Status:finished
 */
public class FiveTongceng002 {
    public int[] removeDuplicate (int[] array) {
        int len = array.length;
        //ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> exitMap = new HashMap<>();
        for (int i = len-1; i >=0 ; i--) {
            if (!exitMap.containsKey(array[i])){
                stack.push(array[i]);
                exitMap.put(array[i],1);
            }
        }
        int n = stack.size();
        int[] tmp = new int[n];
        for (int i = 0; i < n ; i++) {
            tmp[i] = stack.pop();
        }
        return tmp;
    }
}
