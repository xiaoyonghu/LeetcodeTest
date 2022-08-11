package com.huster.leetcode.SwordToOffer.PartitionOne;

import com.huster.leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by Divo
 * @date 2019/10/9
 * Description:重建二叉树
 * Thought:这个题目最主要的就是选点，在中序里面查找前序中的第一个的位置，
 * 然后以prestart+1 ,prestart+i-instart  instart i-1  递归构建左子树
 * 以 prestart+i-instart+1 , preend   i+1 inend 递归构建右子树
 * Status:Finished
 */
public class Test7 {
//    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
//        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
//        return root;
//    }
//
//    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
//        if (preStart > preEnd || inStart > inEnd)
//            return null;
//        TreeNode root = new TreeNode(pre[preStart]);
//        //直接到中序里面查找相应的根节点，只需要得到中序里面index即可
//        //中序就是导航的作用
//        for (int i = inStart; i < inEnd; i++) {
//            if (in[i] == pre[preStart]) {
//                root.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
//                root.right = reConstructBinaryTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
//                //只要找到一个即结束for循环
//                break;
//            }
//        }
//        return root;
//    }

    private Map<Integer, Integer> indexForInOrders = new HashMap<>();

    // HashMap<Integer, Integer> hashMap = new HashMap<>();

    //思路还是可以的，只要对前、中、后序的遍历顺序是了解的即可
    // OA上显示比较跑的比较垃圾
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexForInOrders.put(inorder[i], i);
        }
        TreeNode root = reConstructBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    //节点建立O(N),  每个节点的搜索log(N),最坏的情况是链表结构O(N)
    //所以时间节点为Nlog(N)，最坏的情况为O(N*2)

    //空间复杂度：未使用任何额外空间 O(1)
//    public TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
//        if (preStart > preEnd || inStart > inEnd) { //这里用来返回null节点
//            return null;
//        }
//        TreeNode root = new TreeNode(pre[preStart]);//赋值操作
//        for (int i = inStart; i <= inEnd; i++) {
//            // 前序遍历的root节点  中序遍历中的root节点
//            if (pre[preStart] == in[i]) {
//                root.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
//                root.right = reConstructBinaryTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
//                break;
//            }
//        }
//        return root;
//    }


    //简化上面的搜索时间复杂度，使用空间换时间
    //时间复杂度O（N）
    //空间复杂度O（N）
    public TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) { //这里用来返回null节点
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);//赋值操作

        int i = indexForInOrders.get(pre[preStart]); //中序遍历的索引

        root.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
        root.right = reConstructBinaryTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);

        return root;
    }

}
