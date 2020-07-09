package com.huster.leetcode.PartitionFour;

import com.huster.leetcode.utils.ListNode;

/**
 * @author Created by Divo
 * @date 2020/4/14
 * Description:2个链表的第一个公共节点
 * Status:
 */
public class test52 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        //1、先遍历2个表的长度，长的先走2个的差，第一个相等的就是他了
        //2、先遍历2个数组，然后入栈。按照顺序弹出，最后一个相等的就是他了
        // 3、a+c  b+c   a+c+b=b+c+a
        ListNode p1=pHead1,p2=pHead2;
        while (p1 != p2){
             p1=(p1 ==null)? pHead2 : p1.next;
             p2=(p2 ==null)? pHead1 : p2.next;
        }
        return p1;

    }
}

