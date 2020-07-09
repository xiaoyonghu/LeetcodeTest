package com.huster.leetcode.common;

/**
 * 树结构的通用类
 * @author Created by Divo
 * @date 2019/12/4
 */
public class TreeLinkNode {
    int val;
    TreeLinkNode left=null;
    TreeLinkNode right=null;
    TreeLinkNode next=null;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeLinkNode getLeft() {
        return left;
    }

    public void setLeft(TreeLinkNode left) {
        this.left = left;
    }

    public TreeLinkNode getRight() {
        return right;
    }

    public void setRight(TreeLinkNode right) {
        this.right = right;
    }

    public TreeLinkNode getNext() {
        return next;
    }

    public void setNext(TreeLinkNode next) {
        this.next = next;
    }

    TreeLinkNode(int val){
        this.val=val;
    }
}
