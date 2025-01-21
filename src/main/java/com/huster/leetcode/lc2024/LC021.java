package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.ListNode;
import com.huster.leetcode.utils.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/20 21:41
 * @Desc 合并两个有序链表
 */
public class LC021 {
    public static void main(String[] args) {
        List<Integer> listOne = Arrays.asList(1, 2, 4);
        List<Integer> listTwo = Arrays.asList(1, 3, 4);

//        List<Integer> listOne = Arrays.asList();
//        List<Integer> listTwo = Arrays.asList(0);
        ListNode list1 = ListUtil.createList(listOne);
        ListNode list2 = ListUtil.createList(listTwo);
        LC021 lc021 = new LC021();
//        ListNode listNode = lc021.mergeTwoLists(list1, list2);
        ListNode listNode = lc021.mergeTwoLists(list1, list2);
        ListNode cur = listNode;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
    }

    /**
     * 这种代码就简洁！！！
     **/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val >= p2.val) {
                cur.next = p2;
                p2 = p2.next;
            } else {
                cur.next = p1;
                p1 = p1.next;
            }
            cur = cur.next;
        }

        cur.next = p1 == null ? p2 : p1;

        return preHead.next;
    }

    /**
     * 使用2个指针，各种条件判断比较繁琐，赋值那一块应该有优化空间
     **/
    public ListNode mergeTwoListsLAJI(ListNode list1, ListNode list2) {
        // 每边都是用一个指针 如果谁大，就移动另外一个
        // 如果有一边还有剩下的，直接拼接起来即可
        // 使用额外的链表空间，每边只用一个指针
        ListNode pre  = null, next = null, resHead =null;

        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) { //谁小用谁
            if (p1.val >= p2.val) {
                next = p2;
                p2 = p2.next;
            } else {
                next = p1;
                p1 = p1.next;
            }
            if (pre != null){
                pre.next = next;
            }
            pre = next;
            if (resHead == null){
                resHead = pre;
            }
        }
        while (p1 != null) { // 拼接上list1剩余元素
            next = p1;
            p1 = p1.next;
            if (pre != null){
                pre.next = next;
            }
            pre = next;
            if (resHead == null){
                resHead = pre;
            }
        }
        while (p2 != null) { // 拼接上list2剩余元素
            next = p2;
            p2 = p2.next;
            if (pre != null){
                pre.next = next;
            }
            pre = next;
            if (resHead == null){
                resHead = pre;
            }
        }
        return resHead;
    }

    /**
     * 遍历各种的链表一次，然后将数据按照大小进行排序，根据排序的链表构成一个新的链表
     **/
    public ListNode mergeTwoListsTwo(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();

        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val >= p2.val) {
                list.add(p2.val);
                p2 = p2.next;
            } else {
                list.add(p1.val);
                p1 = p1.next;
            }
        }
        while (p1 != null) { // 拼接上list1剩余元素
            list.add(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) { // 拼接上list2剩余元素
            list.add(p2.val);
            p2 = p2.next;
        }

        if (list == null || list.size() == 0) {
            return null;
        }
        ListNode head = new ListNode(list.get(0));
        ListNode current = head;

        for (int i = 1; i < list.size(); i++) {
            current.next = new ListNode(list.get(i));
            current = current.next;
        }

        return head;
    }

}
