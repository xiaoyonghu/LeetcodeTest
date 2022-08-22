package com.huster.leetcode.SwordToOffer.PartitionTwo;

import com.huster.leetcode.utils.ListNode;

/**
 * @author Yongshao
 * @Date 2022/8/22
 * Description:合并2个排序的列表
 * 前提：2个递增的链表 合并为一个单调递增的链表
 */
public class Test25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //遍历2个，谁小直接把水吞并
        ListNode cur = null, nHead = null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        while (l1 != null && l2 != null) {
            // l1值小
            if (l1.val <= l2.val) {
                if (nHead == null) {
                    nHead = cur = l1;
                } else {
                    cur.next = l1;
                    cur = cur.next;
                }
                l1 = l1.next;
            } else {
                if (nHead == null) {
                    nHead = cur = l2;
                } else {
                    cur.next = l2;
                    cur = cur.next;
                }
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        return nHead;
    }

    public static void main(String[] args) {

    }
}
