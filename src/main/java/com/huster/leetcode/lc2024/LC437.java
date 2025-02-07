package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;
import com.huster.leetcode.utils.TreeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/2/6 22:36
 * @Desc 路径总和 III
 */
public class LC437 {
    List<Integer> pathValList = new ArrayList<>();
    int res = 0;

    public static void main(String[] args) {

        List<Integer> list = Arrays
//                .asList(1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000);
                .asList(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1);
//                .asList(0,1,1);
        TreeNode root = TreeUtil.createBinaryTree(list);
        LC437 lc437 = new LC437();
//        int k = 0;
        int k = 8;
        int result = lc437.pathSumPrefix(root, k);
        System.out.println(result);
//        System.out.println(Integer.MAX_VALUE);
    }


    // 1、二叉树先序遍历递归DFS，使用一个列表存储路径上所有的
    // 进来的时候都看是否有列表中的部分连续元素的值为target
    // TimeConsume(O(N*2))
    public int pathSum(TreeNode root, int targetSum) {
        // 回溯
        pathSumDFS(root, targetSum);
        return res;
    }

    private void pathSumDFS(TreeNode root, int targetSum) {
        if (root == null) return;
        pathValList.add(root.val);
//        if (hasTargetVal(targetSum)) {
//            res++;
//        }
        incCount(targetSum); // 因为这里是先对一部分的进行的和的计算
        pathSumDFS(root.left, targetSum);
        pathSumDFS(root.right, targetSum);
        pathValList.remove(pathValList.size() - 1);
    }

    // 遍历list，从最后往前遍历，考虑所有的
    private void incCount(int targetSum) {
        long sum = 0L;
        for (int i = pathValList.size() - 1; i >= 0; i--) {
            sum += (long)pathValList.get(i);
            if (sum == (long) targetSum) {
                res++;
            }
        }
    }

    // 遍历list，从最后往前遍历，只要有一条为target值，则OK
    private boolean hasTargetVal(int targetSum) {
        int sum = 0;
        for (int i = pathValList.size() - 1; i >= 0; i--) {
            sum += pathValList.get(i);
            if (sum == targetSum) return true;
        }
        return false;
    }


    // 2、前缀和
    public int pathSumPrefix(TreeNode root, int targetSum) {
        long pre = 0;
        // key：pre - (long)sum
        // val: 出现的次数
        HashMap<Long, Integer> hashMap = new HashMap<>();
        hashMap.put(0L, 1);
        recursionPathSum(root, targetSum, hashMap, pre);
        return res;
    }

    /**
     * 前缀和  +  递归回溯
     */
    private void recursionPathSum(TreeNode cur, int sum, HashMap<Long, Integer> hashMap, long pre) {
        if (cur == null)
            return;

        pre += cur.val;

        //TODO：明天看
        res += hashMap.getOrDefault(pre - (long)sum, 0);
        hashMap.put(pre, hashMap.getOrDefault(pre, 0) + 1);

        recursionPathSum(cur.left, sum, hashMap, pre);
        recursionPathSum(cur.right, sum, hashMap, pre);

        //恢复状态
        hashMap.put(pre, hashMap.get(pre) - 1);
    }
}
