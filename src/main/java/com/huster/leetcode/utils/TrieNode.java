package com.huster.leetcode.utils;

/**
 * @author Created by Divo
 * @date 2020/8/4
 * Description:用于构造前缀树
 * Status:new
 */
public class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {
    }

    public TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}