package com.huster.leetcode.SwordToOffer.PartitionTwo;

import com.huster.leetcode.utils.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * @author Yongshao
 * @Date 2022/8/22
 * Description: 反转链表
 */
public class Test24 {
//    public ListNode reverseList(ListNode head) {
//        while (head == null) return head;
//        //遍历链表2次，使用一个栈来保存（额外的空间）
//        Stack<Integer> stack = new Stack<>();
//        ListNode p = head;
//        while (p != null) {
//            stack.push(p.val);
//            p = p.next;
//        }
//        //第二遍遍历
//        p = head;
//        while (p != null) {
//            p.val = stack.pop();
//            p = p.next;
//        }
//        return head;
//    }

    //使用遍历一次，2个指针来实现
    public ListNode reverseList(ListNode head) {
        while (head == null) return head;
        ListNode cur = head, pre = null, next = null, revHead = null;
        while (cur != null) {
            next = cur.next;
            //确定翻转首节点
            if (next == null) revHead = cur;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return revHead;
    }

    public static void main(String[] args) {

    }
}
