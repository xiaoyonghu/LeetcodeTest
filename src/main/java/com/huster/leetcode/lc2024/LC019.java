package com.huster.leetcode.lc2024;

import com.huster.leetcode.utils.ListNode;
import com.huster.leetcode.utils.ListUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/22 21:24
 * @Desc 删除链表中的倒数第N个节点
 */
public class LC019 {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        int n = 2;

//        List<Integer> list = Arrays.asList(1);
//        int n =1;

        List<Integer> list = Arrays.asList(1,2);
        int n =1;
        ListNode head = ListUtil.createList(list);
        LC019 lc019 = new LC019();
        ListNode listNode = lc019.removeNthFromEnd(head, n);
        ListNode cur = listNode;
        while (cur != null){
            System.out.println(cur.val + "->" );
            cur = cur.next;
        }

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        // 冗余判断
        int count = 0;
        ListNode countP = head;
        while (countP != null) { // 统计链表长度
            count++;
            countP = countP.next;
        }
        if (count < n) return head; // 倒数节点比整个链表长度还长，直接返回头结点
        //   kpre  delayK  k
        ListNode kpre = null, delayK = head, k = head ;
        while (n > 0) {   // k节点先走K步
            k = k.next;
            n--;
        }

        while (k != null) {  // 同时移动
            kpre = delayK;
            delayK = delayK.next;
            k = k.next;
        }
        if (kpre == null) {  // 表示删除的是头结点
            return delayK.next;
        }else {
            kpre.next = delayK.next; // 删除k节点
        }
        return head;
    }
}
