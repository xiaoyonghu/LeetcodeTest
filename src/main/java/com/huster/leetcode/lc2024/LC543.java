package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;
import com.huster.leetcode.utils.TreeUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/14 22:21
 * @Desc 二叉树的直径
 */
public class LC543 {

    public static void main(String[] args) {
        LC543 lc543 = new LC543();
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> list = Arrays.asList(1, 2);
        List<Integer> list = Arrays
                .asList(4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2);
        TreeNode root = TreeUtil.createBinaryTree(list);
//        System.out.println(diameterOfBinaryTree(root));


        lc543.diameterOfBinaryTree(root);
        System.out.println(-1);
    }

    int maxL;

    // 递归遍历版本
    // 分为2棵树？？
    public int diameterOfBinaryTree(TreeNode root) {
        maxL= 0;
        // 后续遍历 思路
        fix(root);
        return maxL - 1;

//        if (root == null) return 0;
//        int leftMaxDeep = sumMaxDeep(root.left);
//        int rightMaxDeep = sumMaxDeep(root.right);
//        return leftMaxDeep + rightMaxDeep;
    }

    public int fix(TreeNode root) {
        if (root == null) return 0;
        int leftMaxDeep = fix(root.left);
        int rightMaxDeep = fix(root.right);
        maxL = Math.max(maxL, leftMaxDeep + rightMaxDeep + 1); // 每次计算最大的直径
        return Math.max(leftMaxDeep, rightMaxDeep) + 1; //返回最大深度
    }


    public  int sumMaxDeep(TreeNode root){
        if (root == null) return 0;
        int left = sumMaxDeep(root.left);
        int right = sumMaxDeep(root.right);
        return Math.max(left, right) + 1;
    }

}
