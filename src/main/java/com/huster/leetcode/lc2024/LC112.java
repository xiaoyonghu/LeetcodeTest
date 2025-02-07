package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;
import com.huster.leetcode.utils.TreeUtil;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/2/6 22:51
 * @Desc 路径总和
 */
public class LC112 {
    public static void main(String[] args) {
        List<Integer> list = Arrays
//                .asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1);
                .asList(1,2,3);
        TreeNode root = TreeUtil.createBinaryTree(list);
        LC112 lc112 = new LC112();
//        int target = 22;
        int target = 5;
        boolean hasPathSum = lc112.hasPathSum(root, target);
        System.out.println(hasPathSum);
    }


    /**
     * @Author Syong
     * @Description 使用递归来做
     **/
    public boolean hasPathSumUsingDFS(TreeNode root, int targetSum) {
        // 使用前序遍历
        int sum = 0;
        return hasPathSumDFS(root, targetSum, sum);
    }
    // 1、使用的是递归
    // 能过case，但是很低(加法和减法都一样的思路)
    private boolean hasPathSumDFS(TreeNode root, int targetSum, int sum) {
        if (root == null) return false;

        // below code is just for testing
//        System.out.println("cur val " + root.val);
//        System.out.println("sum val " + sum);
//        System.out.println("total sum : " + (sum + root.val));
//        System.out.println();
        if (root.left ==null && root.right == null && (sum+root.val) == targetSum){
            return true;
        }
        boolean left =false, right =false;
        // 其实下面这里可以优化（因为函数最开始已经写了）
        if (root.left != null) {
            left = hasPathSumDFS(root.left, targetSum, sum + root.val);
        }
        if (root.right != null) {
            right = hasPathSumDFS(root.right, targetSum, sum + root.val);
        }
        return left || right;
    }

    /**
     * @Author Syong
     * @Description 使用二叉树的非递归来做（BFS层次遍历）
     **/
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 使用2个队列，一个队列存储值、一个队列存储包括该节点后的路径总和
        if (root == null) return false;
        Deque<Integer> valQueue = new ArrayDeque<>();
        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        valQueue.addLast(root.val);
        nodeQueue.addLast(root);
        while (!nodeQueue.isEmpty()){
            int pathTotalVal = valQueue.pollFirst();
            TreeNode curNode = nodeQueue.pollFirst();
            if (curNode.left == null && curNode.right == null && pathTotalVal == targetSum )
                return true;
            if (curNode.left!= null){
                nodeQueue.addLast(curNode.left);
                valQueue.addLast(pathTotalVal+curNode.left.val);
            }
            if (curNode.right!= null){
                nodeQueue.addLast(curNode.right);
                valQueue.addLast(pathTotalVal+curNode.right.val);
            }
        }
        return false;
    }
}
