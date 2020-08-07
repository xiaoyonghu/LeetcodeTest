package com.huster.leetcode.Leetcode;


import java.util.LinkedList;
import java.util.List;

/**
 * @author Created by Divo
 * @date 2020/8/4
 * Description:Exam94 212 单词搜索
 * Status:new
 */
public class Exam212 {

//    public List<String> findWords(char[][] board, String[] words) {
//        List<String> res = new ArrayList<>();
//        int m=board.length;
//        int n=board[0].length;
//        TrieNode root = buildTrie(words);
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                dfs (board, i, j, m, n, root, res);
//            }
//        }
//        return res;
//    }
//
//    public void dfs(char[][] board, int i, int j,int m,int n, TrieNode p, List<String> res) {
//        //1、终止条件
//        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j]=='#')
//            return;
//        //2、process current node
//        char c = board[i][j];
//        if (c == '#' || p.next[c - 'a'] == null) return;  //#表示已经被访问，也可以用visited数组来实现
//        p = p.next[c - 'a'];
//        if (p.word != null) {   // found one
//            res.add(p.word);
//            p.word = null;     // de-duplicate
//        }
//        board[i][j] = '#'; //修改状态
//
//        //3、递归调用下一层
//        dfs(board, i - 1, j, m, n ,p, res);
//        dfs(board, i, j - 1, m, n, p, res);
//        dfs(board, i + 1, j, m, n ,p, res);
//        dfs(board, i, j + 1, m, n, p, res);
//
//        //4、恢复状态
//        board[i][j] = c;
//    }
//
//    public TrieNode buildTrie(String[] words) {
//        TrieNode root = new TrieNode();
//        for (String w : words) {
//            TrieNode p = root;
//            for (char c : w.toCharArray()) {
//                int i = c - 'a';
//                if (p.next[i] == null) p.next[i] = new TrieNode();
//                p = p.next[i];
//            }
//            p.word = w;
//        }
//        return root;
//    }
//
//    class TrieNode {
//        TrieNode[] next = new TrieNode[26];
//        /**
//         * 最后节点存储整个字符串
//         */
//        String word;
//    }


    public List<String> findWords(char[][] board, String[] words) {
        WordTride wordTride = new WordTride();
        TrideNode1 root = wordTride.root;
        for (String s : words) {
            wordTride.insert(s);
        }
        List<String> result = new LinkedList<>();
        //矩阵行数
        int m = board.length;
        //矩阵列数
        int n = board[0].length;
        //存储该节点是否访问
        boolean[][] visited = new boolean[m][n];
        //遍历整个二维数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                find(board, visited, i, j, m, n, result, root);
            }
        }
        return result;
    }

    private void find(char[][] board, boolean[][] visited, int i, int j, int m, int n, List<String> result, TrideNode1 cur) {
        //1、终止条件
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j])
            return;
        //2、process current node
        cur = cur.child[board[i][j]-'a'];
        if (cur == null)
            return;

        if (cur.isWord) {
            result.add(cur.val);
            cur.isWord = false;
        }
        visited[i][j] = true;

        //3、递归调用下一层
        find(board, visited, i + 1, j, m, n, result, cur);
        find(board, visited, i - 1, j, m, n, result, cur);
        find(board, visited, i, j + 1, m, n, result, cur);
        find(board, visited, i, j - 1, m, n, result, cur);
        //4、恢复状态
        visited[i][j] = false;

    }

    class WordTride {
        TrideNode1 root = new TrideNode1();

        public void insert(String s) {
            TrideNode1 cur = root;
            for (char c : s.toCharArray()) {
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new TrideNode1();
                }
                cur = cur.child[c - 'a'];
            }
            cur.isWord = true;
            cur.val = s;
        }
    }

    class TrideNode1 {
        String val;
        TrideNode1[] child = new TrideNode1[26];
        /**
         * 是否为最后的叶子节点
         */
        boolean isWord;
    }


}
