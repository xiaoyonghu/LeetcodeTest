package com.huster.leetcode.PartitionOne;

import com.huster.leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by Divo
 * @date 2019/10/9
 * Description:重建二叉树
 * Thought:这个题目最主要的就是选点，在中序里面查找前序中的第一个的位置，
 *                             然后以prestart+1 ,prestart+i-instart  instart i-1  递归构建左子树
 *                             以 prestart+i-instart+1 , preend   i+1 inend 递归构建右子树
 * Status:Finished
 */
public class Test7 {
     public TreeNode reConstructBinaryTree(int [] pre , int [] in ){
         TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
         return root;
      }

    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
         if(preStart>preEnd || inStart>inEnd)
             return null;
        TreeNode root=new TreeNode(pre[preStart]);
        //直接到中序里面查找相应的根节点，只需要得到中序里面index即可
        //里面的中序就是导航的作用
        for (int i = inStart; i < inEnd; i++) {
            if(in[i] == pre[preStart]){
                root.left=reConstructBinaryTree(pre,preStart+1 ,preStart+i-inStart ,in, inStart, i-1);
                root.right=reConstructBinaryTree(pre,preStart+i-inStart+1 , preEnd  ,in, i+1 ,inEnd);
                 //只要找到一个即结束for循环
                break;
            }
        }
         return root;
     }

    private Map<Integer, Integer> indexForInOrders = new HashMap<>();
}
