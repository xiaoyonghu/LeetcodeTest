package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;

import java.util.*;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/7 23:05
 * @Desc 二叉树的中序遍历
 */
public class LC094 {
    public static void main(String[] args) {
        // 第一种是递归
        // 第二种不是递归
        List<Integer> levelOrder = Arrays.asList(1, null, 2, 3);
        TreeNode root = createBinaryTree(levelOrder);
        inorderTraversalNotDfs(root).forEach(x -> System.out.println(x + ":"));
//        inorderTraversal1111(root).forEach(x -> System.out.println(x + ":"));
    }

    //1、递归
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        dfsInorderTraversal(root, inOrderList);
        return inOrderList;
    }

    private void dfsInorderTraversal(TreeNode root, List<Integer> inOrderList) {
        if (root == null) return;
        dfsInorderTraversal(root.left, inOrderList);
        inOrderList.add(root.val);
        dfsInorderTraversal(root.right, inOrderList);
    }


    //2、使用非递归（递归模板）
    public static List<Integer> inorderTraversalNotDfs(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            inOrderList.add(p.val);
            p = p.right;
        }
        return inOrderList;
    }

    public static List<Integer> inorderTraversal1111(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // 一直遍历左子树，直到左子树为空
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // 当前节点为空，表示左子树已经遍历完
            // 弹出栈顶元素，并访问它
            current = stack.pop();
//            System.out.print(current.val + " ");
            inOrderList.add(current.val);

            // 转向右子树
            current = current.right;
        }
        return inOrderList;
    }


    // 根据层次遍历序列构建二叉树
    public static TreeNode createBinaryTree(List<Integer> levelOrder) {
        if (levelOrder == null || levelOrder.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < levelOrder.size()) {
            TreeNode currentNode = queue.poll();

            if (levelOrder.get(i) != null) {
                currentNode.left = new TreeNode(levelOrder.get(i));
                queue.offer(currentNode.left);
            }
            i++;

            if (i < levelOrder.size() && levelOrder.get(i) != null) {
                currentNode.right = new TreeNode(levelOrder.get(i));
                queue.offer(currentNode.right);
            }
            i++;
        }
        return root;
    }
}
