package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

import java.util.HashMap;

/**
 * @author Created by Divo
 * @date 2020/8/7
 * Description:lc 437 路径总结III
 *      1、前缀和 + 回溯
 *      2、双重递归 a.整棵树的递归 b.每个节点的树的递归
 * Status:finished
 */
public class Exam437 {
    /**
     * 先看lc 560题目，前缀树
     */
    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        int pre = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        recursionPathSum(root, sum, hashMap, pre);
        return res;
    }

    /**
     * 前缀树  +  递归回溯
     */
    private void recursionPathSum(TreeNode cur, int sum, HashMap<Integer, Integer> hashMap, int pre) {
        if (cur == null)
            return;

        pre += cur.val;

        res += hashMap.getOrDefault(pre - sum, 0);
        hashMap.put(pre, hashMap.getOrDefault(pre, 0) + 1);

        recursionPathSum(cur.left, sum, hashMap, pre);
        recursionPathSum(cur.right, sum, hashMap, pre);

        //恢复状态
        hashMap.put(pre, hashMap.get(pre) - 1);
        //pre -= cur.val;
    }
}
