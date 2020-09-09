package com.huster.leetcode.fallHireExam.souGou;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/9/6
 * Description:换密码问题
 * Status:finished
 * Extra:see more information click<href>https://blog.csdn.net/weixin_41896265/article/details/108424304<href/>
 */
public class souGou003 {
    public long getPasswordCount(String password) {
        //cList用来记过程中已经遍历的数
        Deque<Character> track = new LinkedList<>();
        //如果用int count来计数，
        int[] res=new int[1];
        char[] chars = password.toCharArray();
        backTrack(chars, res, 0, track);
        return res[0];
    }

    private void backTrack(char[] chars, int[] count, int start, Deque<Character> track) {
        if (track.size() == chars.length) {
            if (!checkEquals(track, chars)) {
                count[0]++;
            }
            return;
        }
        if (start == 0) {
            for (int i = 0; i < 10; i++) {
                track.addLast((char) ('0' + (i - 0)));
                backTrack(chars, count, start + 1, track);
                track.removeLast();
            }
        } else {
            int cur = (chars[start] - '0') + (track.peekLast() - '0');
            //如果为偶数，取一个
            if ((cur & 1) == 0) {
                track.addLast((char) (cur / 2 + '0'));
                backTrack(chars, count, start + 1, track);
                track.removeLast();
                //如果为奇数，取2个
            } else {
                for (int i = 0; i < 2; i++) { //2次
                    track.addLast((char) ((cur / 2 + i) + '0'));
                    backTrack(chars, count, start + 1, track);
                    track.removeLast();
                }
            }
        }
    }
    private boolean checkEquals(Deque<Character> track, char[] chars) {
        int index = 0;
        for (Character c : track) {
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
