package com.huster.leetcode.utils;

/**
 * @author Created by Divo
 * @date 2020/8/4
 * Description:lc 208 前缀树的构造
 * Status:finished
 */
public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie(){
        root = new TrieNode();
        root.val= ' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c=word.charAt(i);
            if (cur.children[c-'a'] == null){
                cur.children[c-'a'] =new TrieNode(c);
            }
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c=word.charAt(i);
            if (cur.children[c-'a'] == null){
                return false;
            }
            cur = cur.children[c-'a'];
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c=prefix.charAt(i);
            if (cur.children[c-'a'] == null)
                return false;
            cur = cur.children[c-'a'];
        }
        return true;
    }
}
