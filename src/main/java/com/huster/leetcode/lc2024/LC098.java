package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.TreeNode;

import java.util.*;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/6 21:42
 * @Desc 验证二叉搜索树
 */
public class LC098 {
    public static void main(String[] args) {
        //root = [2,1,3] true
//        int[] list = {2, 1, 3};
        //root = [5,1,4,null,null,3,6]  false
        // 使用BFS的数据构建二叉树
//        List<Integer> levelOrder = Arrays.asList(5, 1, 4, null, null, 3, 6);
//        List<Integer> levelOrder = Arrays.asList(2,1,3);
//        List<Integer> levelOrder = Arrays.asList(0);
        List<Integer> levelOrder = Arrays.asList(1,1);

        TreeNode root = createBinaryTree(levelOrder);
//        System.out.println(isValidBSTUsingTricky(root));
//        isValidBSTUsingRecur(root);
        System.out.println(isValidBSTUsingInorder(root));
    }
    /**
     * 总共有2中解法：
     *  1、二叉搜索树的特性："中序" 序列是严格递增的
     *  2、递归(取巧递归、加前驱指针的递归)
     **/

    /**
     * @Author Syong
     * @Description 1、使用二叉树"递归"取巧
     **/
    public static boolean isValidBSTUsingTricky(TreeNode root) {
        // 使用tricky递归
        return TrickyDfs(root, null, null);
    }

    private static boolean TrickyDfs(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return TrickyDfs(root.left, min, root) && TrickyDfs(root.right, root, max);
    }

    // 2、使用中序递归遍历方法（在一个前驱的指针即可）
    public static TreeNode pre = null;
    public static boolean isValidBSTUsingInorder(TreeNode root) {
        // 使用tricky递归
//        if (root.val == 1) return true;
       return helper(root);
    }

    private static boolean helper(TreeNode root) {
        if (root == null) return true;
        if (!helper(root.left)) return false;
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        return helper(root.right);
    }
    // 2、使用中序方法，使用非递归版的，外加一个前驱指针
    public static boolean isValidBST(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode p = root;
        while (p != null || !nodeStack.isEmpty()) {
            while (p != null) {
                nodeStack.push(p);
                p = p.left;
            }
            p = nodeStack.pop();
            if (pre != null && pre.val >= p.val) return false;
            pre = p;
            p = p.right;
        }
        return true;
    }


    // 3、二叉搜索树的特性："中序" 序列是严格递增的
    // 使用一整个列表来接住遍历到的每一个值
    public static boolean isValidBSTUsingRecur(TreeNode root) {
        // 二叉搜索树的特性："中序" 序列是严格递增的
        List<Integer> orderList = new ArrayList<>();
        dfsInorderList(root, orderList);
//        orderList.forEach(x -> System.out.println(x + " "));
        Collections.sort(orderList);
        orderList.forEach(x -> System.out.println(x + " "));
        // java语言写这种太弱了，比较一个数组的遍历后与遍历前是否完全一样
        return false;
    }
    private static void dfsInorderList(TreeNode root, List<Integer> orderList) {
        if (root == null) return;
        dfsInorderList(root.left, orderList);
        orderList.add(root.val);
        dfsInorderList(root.right, orderList);
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
