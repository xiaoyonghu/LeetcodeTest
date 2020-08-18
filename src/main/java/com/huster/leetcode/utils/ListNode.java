package com.huster.leetcode.utils;

/**
 * @author Created by Divo
 * @date 2019/10/9
 * Description:用来表示单链表的节点
 * Status:finished
 */

public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
