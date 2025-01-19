package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;
import com.huster.leetcode.utils.TreeUtil;

import java.util.*;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/19 21:57
 * @Desc 二叉树的右视图
 */
public class LC199 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, null, 5, null, 4);
        TreeNode root = TreeUtil.createBinaryTree(list);
        LC199 lc199 = new LC199();
        System.out.println(lc199.rightSideView(root));
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) return resList;
        Deque<TreeNode> queue= new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.pop();
                // 在这里判断
                if (i == (size -1)){
                    resList.add(pop.val);
                }
                if (pop.left!=null) queue.offer(pop.left);
                if (pop.right!=null) queue.offer(pop.right);
            }
        }

        // BFS 层级遍历，且带数
        return resList;
    }
}
