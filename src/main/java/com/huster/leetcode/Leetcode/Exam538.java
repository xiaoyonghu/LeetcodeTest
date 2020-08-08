package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.TreeNode;

/**
 * @author Created by Divo
 * @date 2020/8/7
 * Description:lc 538 把二叉树搜索树转换为累加树
 * Status:finished
 */
public class Exam538 {
    /**
     * 变形的中序  右 --> 中 -->左
     * 感觉被自己菜哭了，一看就知道思路，就是写不出来，mmp.为毛要想细节
     *
     * @param root
     * @return
     */
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        inProcess(root);
        return root;
    }

    private void inProcess(TreeNode cur) {
        if (cur == null)
            return;
        inProcess(cur.right);
        cur.val += sum;
        sum = cur.val;
        inProcess(cur.left);
    }
}
