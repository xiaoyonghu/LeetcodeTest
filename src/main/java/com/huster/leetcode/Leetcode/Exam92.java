package com.huster.leetcode.Leetcode;

import com.huster.leetcode.utils.ListNode;

public class Exam92 {

    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pLeft = dummyNode;


        ListNode wHead = head;
        ListNode r = null, rRight = null, l = null;
        int len = 0;

        while (wHead != null) {
            len++;
            if (len == (left - 1)) {
                pLeft = wHead;
            }
            if (len == left) {
                l = wHead;
            }
            if (len == right) {
                r = wHead;
            }
            if (len == (right + 1)) {
                rRight = wHead;
            }
            wHead = wHead.next;
        }

        //断开节点
        pLeft.next = null;
        r.next = null;

        //reverse left--right area, and not return RevHead
        reverseLR(l);

        //接上
        pLeft.next = r;
        l.next = rRight;

        return dummyNode.next;
    }

    private void reverseLR(ListNode head) {
        ListNode cur = head, pre = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
    }
}
