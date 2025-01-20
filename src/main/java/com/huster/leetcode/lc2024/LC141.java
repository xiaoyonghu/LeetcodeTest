package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/20 21:39
 * @Desc 环形链表
 */
public class LC141 {
    public static void main(String[] args) {
        // 可以使用 map<Int,Int> key:val val:index
        // 数学证明？
    }

    // 数学证明：快慢指针 Floyd 判圈算法(没必要证明)
    // 一个1步，一个2步
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 上面的while跳出了循环
        return true;
    }


    // 第一次知道这个add居然还有这种用法
    public boolean hasCycleTwo(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null){
            if (!set.add(cur)) return true;
            cur = cur.next;
        }
        return false;
    }

    // 前提：每个数字不一样，具备唯一性（下面的方法才可以）
    @Deprecated
    public boolean hasCycleOne(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null){
            if (set.contains(cur.val)) return true;
            set.add(cur.val);
            cur = cur.next;
        }
        return false;
    }

}
