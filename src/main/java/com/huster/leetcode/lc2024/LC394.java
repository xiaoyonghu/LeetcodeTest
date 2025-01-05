package com.huster.leetcode.lc2024;

import java.util.*;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/5 15:26
 * @Desc 字符串解码
 */
public class LC394 {
    public static void main(String[] args) {
        String s = "3[a2[bc]]";
        // abcbc
        System.out.println(decodeString(s));
        // output = "accaccacc"

//        char testa = '8';
//        System.out.println(isBetween(testa));
    }

    public static String decodeString(String s) {
        Stack<Character> characterStack = new Stack<>();
        Stack<Character> resStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') {
                List<Character> charList = new ArrayList<>();
                while (characterStack.peek() != '['){
                    Character pop = characterStack.pop();
                    charList.add(pop);
                }
                characterStack.pop(); // remove '['

                int gap = 1;
                int totalNum = 0;
                while (!characterStack.isEmpty() && Character.isDigit(characterStack.peek())) {
                    int num = characterStack.pop() - '0';
                    totalNum += num * gap;
                    gap = gap * 10;
                }
                for (int j = 0; j < totalNum; j++) {
                    for (int k = charList.size() - 1; k >= 0; k--) {
                        characterStack.add(charList.get(k));
                    }
                }
            } else {
                characterStack.push(c);
            }
        }

        while (!characterStack.isEmpty()) {
            resStack.add(characterStack.pop());
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!resStack.isEmpty()) {
            stringBuffer.append(resStack.pop());
        }

        return stringBuffer.toString();
    }

}
