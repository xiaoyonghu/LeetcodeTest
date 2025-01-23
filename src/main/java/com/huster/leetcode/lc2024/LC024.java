package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.ListNode;
import com.huster.leetcode.utils.ListUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/22 22:21
 * @Desc 两两交换链表中的节点
 */
public class LC024 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        ListNode l1 = ListUtil.createList(list);
        LC024 lc024 = new LC024();
        // 1、使用递归（简单易理解）
        // 2、使用3个变量指针
        ListNode listNode = lc024.swapPairsOne(l1);
        ListNode cur = listNode;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }

    }


    // 1、使用递归
    public ListNode swapPairsRec(ListNode head) {
        // 结束条件
        if (head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        // 递归
        head.next = swapPairsRec(newHead.next);
        // 其他操作
        newHead.next = head;
        return newHead;
    }

    // 2、使用3个变量，后退一步（先前后，然后再换中间）
    public ListNode swapPairsOne(ListNode head) {
        if (head == null) return head;
        ListNode pre = new ListNode(-1);
        ListNode revHead = null;
        pre.next = head;

        while (pre.next != null && pre.next.next != null){
           ListNode cur = pre.next;
           ListNode next = pre.next.next;
           pre.next = next;
           cur.next = next.next;
           next.next = cur;
           pre = cur;
           if (revHead == null){
               revHead = next;
           }
        }
        return revHead;
    }

    // 2、使用4个变量（多前进一步）
    // 这一题对变量边界想了有些久，感觉可以将4个变量换为3个就搞定
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode revHead = null, pre = head, cur = head.next;
        ListNode ppre = new ListNode(-1);
        if (cur == null) return head;
        ListNode next = cur.next;

        while (cur != null) {
            ppre.next = cur;
            cur.next = pre;
            pre.next = next;
            if (revHead == null) revHead = cur;

            if (next == null || next.next == null) {
                break;
            } else {
                next = next.next.next;
                cur = pre.next.next;
                ppre = pre;
                pre = pre.next;
            }
        }
        return revHead;
    }
}
