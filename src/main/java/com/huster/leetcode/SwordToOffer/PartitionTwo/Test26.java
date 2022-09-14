package com.huster.leetcode.SwordToOffer.PartitionTwo;

import com.huster.leetcode.utils.TreeNode;

/**
 * @Author yongshao
 * @create 2022/9/12 12:15
 * Description:
 */
public class Test26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //    A 与 B 都没有为空(还有节点)              以A、B(先序遍历)
        return (A != null && B != null)
                && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    /**
     * 以A、B为根节点是否匹配
     *
     * @param A
     * @param B
     * @return
     */
    private boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        // B != null
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

}
