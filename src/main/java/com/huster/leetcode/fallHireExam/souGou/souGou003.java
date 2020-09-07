package com.huster.leetcode.fallHireExam.souGou;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/6
 * Description:换密码问题
 * Status:finished
 */
public class souGou003 {
    public long getPasswordCount(String password) {
        Deque<Character> cList = new LinkedList<>();
        //如果用int count来计数，
        int[] res=new int[1];
        char[] chars = password.toCharArray();
        backTrack(chars, res, 0, cList);
        return res[0];
    }

    private void backTrack(char[] chars, int[] count, int start, Deque<Character> cList) {
        if (cList.size() == chars.length) {
            if (!checkEquals(cList, chars)) {
                count[0]++;
            }
            return;
        }
        if (start == 0) {
            for (int i = 0; i < 10; i++) {
                cList.addLast((char) ('0' + (i - 0)));
                backTrack(chars, count, start + 1, cList);
                cList.removeLast();
            }
        } else {
            int cur = (chars[start] - '0') + (cList.peekLast() - '0');
            if ((cur & 1) == 0) {
                cList.addLast((char) (cur / 2 + '0'));
                backTrack(chars, count, start + 1, cList);
                cList.removeLast();
            } else {
                for (int i = 0; i < 2; i++) { //2次
                    cList.addLast((char) ((cur / 2 + i) + '0'));
                    backTrack(chars, count, start + 1, cList);
                    cList.removeLast();
                }
            }
        }
    }
    private boolean checkEquals(Deque<Character> cList, char[] chars) {
        int index = 0;
        for (Character c : cList) {
            if (c != chars[index]) {
                return false;
            }
            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        souGou003 souGou003 = new souGou003();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(souGou003.getPasswordCount(s));

    }
}
