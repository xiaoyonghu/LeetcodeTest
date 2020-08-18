package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.ListNode;
import com.huster.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Divo
 * @date 2020/8/18
 * Description:lc 109 有序链表转换二叉搜索树
 * Status:new
 */
public class Exam109 {
    /**
     * //可以使用类似二分查找
     * public TreeNode sortedListToBST(ListNode head) {
     * if (head == null)
     * return null;
     * //空间复杂度为O(N)
     * List<Integer> list = new ArrayList<>();
     * while (head != null) {
     * list.add(head.val);
     * head = head.next;
     * }
     * //使用二分查找
     * return sortedListToBSTHelper(list, 0, list.size() - 1);
     * }
     * <p>
     * //二叉查找的时间复杂度为O（N）
     * private TreeNode sortedListToBSTHelper(List<Integer> list, int left, int right) {
     * if (left > right)
     * return null;
     * int mid = left + (right - left) / 2;
     * TreeNode root = new TreeNode(list.get(mid));
     * root.left = sortedListToBSTHelper(list, left, mid - 1);
     * root.right = sortedListToBSTHelper(list, mid + 1, right);
     * return root;
     * }
     */
    //使用快慢指针
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);

        ListNode slow = head, fast = head, pre = null;
        //slow就是中间节点
        while (fast == null || fast.next == null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;

        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.left = sortedListToBST(slow.next);
        return root;
    }

}
