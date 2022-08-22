package com.huster.leetcode.SwordToOffer.PartitionOne;

import com.huster.leetcode.utils.ListNode;

/**
 * @author Yongshao
 * @Date 2022/8/18
 * Description: 删除链表的节点
 * 思路：找到一个删除的前驱节点（考察链表的删除操作）
 */
public class Test18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode p = head, pre = head, k = head.next;
        while (k != null) {
            if (k.val == val) {
                pre.next = k.next;
                break;
            }
            pre = k;
            k = k.next;
        }
        return p;
    }

    public static void main(String[] args) {

    }
}
