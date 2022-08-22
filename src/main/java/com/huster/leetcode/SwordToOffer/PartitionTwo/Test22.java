package com.huster.leetcode.SwordToOffer.PartitionTwo;

import com.huster.leetcode.utils.ListNode;

/**
 * @author Yongshao
 * @Date 2022/8/22
 * Description: 链表中倒数第K个节点
 */
public class Test22 {

    //第一种，直接遍历2遍，直接算
//    public ListNode getKthFromEnd(ListNode head, int k) {
//        //遍历2遍，第一遍计数，第二遍直接输出
//        if (head == null || k == 0) return null;
//        int count = 0;
//        ListNode t = head;
//        //遍历
//        while (t != null) {
//            count++;
//            t = t.next;
//        }
//
//        //第二次遍历
//        if (k > count) return null;
//        t = head;
//        for (int i = 1; i <= count; i++) {
//            if (i == (count - k + 1)) return t;
//            t = t.next;
//        }
//        return null;
//    }


    //第二种，直接让一个节点先跑K个节点，然后在让后续的一个节点开始跑，然后当最后一个节点为null时，直接返回后续的一个几点即可
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0) return null;

        ListNode preK = head, t = head;
        //先跑K-1个节点
        for (int i = 1; i < k; i++) {
            if (preK == null) return null;
            preK = preK.next;
        }

        if (preK == null) return null;

        while (preK.next != null) {
            t = t.next;
            preK = preK.next;
        }
        return t;
    }

    public static void main(String[] args) {

    }
}
