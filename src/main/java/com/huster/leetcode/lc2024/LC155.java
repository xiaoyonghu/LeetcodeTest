package com.huster.leetcode.lc2024;

import java.util.*;

/**
 * @author Syong
 * @version 1.0
 * @date 2025/1/5 14:15
 * @Desc 最小栈
 */
public class LC155 {
    Stack<Integer> dataStack;
    Stack<Integer> miniStack;

    public static void main(String[] args) {
        LC155 lc155 = null;
        List<String> opList = Arrays.asList("MinStack", "push", "push", "push", "push",
                "pop", "getMin", "pop", "getMin", "pop", "getMin");
        // 初始化二维数组
        Integer[][] myArray = {
                {},               // 等同于 new Integer[0]
                {512},            // 等同于 new Integer[]{512}
                {-1024},          // 等同于 new Integer[]{-1024}
                {-1024},          // 等同于 new Integer[]{-1024}
                {512},            // 等同于 new Integer[]{512}
                {},               // 等同于 new Integer[0]
                {},               // 等同于 new Integer[0]
                {},               // 等同于 new Integer[0]
                {},               // 等同于 new Integer[0]
                {},               // 等同于 new Integer[0]
                {}                // 等同于 new Integer[0]
        };
        for (int i = 0; i < opList.size(); i++) {
            String op = opList.get(i);
            if (op == "MinStack") {
                lc155 = new LC155();
            } else if (op == "push") {
                Integer val = myArray[i][0];
                lc155.push(val);
            } else if (op == "pop") {
                lc155.pop();
            } else if (op == "getMin") {
                int min = lc155.getMin();
                System.out.println("get mini: " + min);
            } else if (op == "top") {
                System.out.println("pop: " + lc155.top());
            }
        }

    }
    /**
     * @Author Syong
     * @Description  参考了lc官方题解
     **/
    public LC155() {
        dataStack = new Stack<>();
        miniStack = new Stack<>();
    }

    public void push(int val) {
        // 把元素入站
        dataStack.push(val);
        // 维持mini次序
        if (miniStack.isEmpty() || miniStack.peek() >= val) {
            miniStack.push(val);
        }
    }

    // 删除堆栈顶部的元素
    public void pop() {
        // 删除
        Integer pop = dataStack.pop();
        // Tips: 注意 == 对Integer包装类型的局限性
        if (Objects.equals(pop,miniStack.peek())){
            miniStack.pop();
        }
    }

    // 获取堆栈顶部的元素。
    public int top() {
        return dataStack.peek();
    }

    // 并能在"常数时间内"检索到最小元素的栈。
    public int getMin() {
        // 从栈中选择最小的这个
        return miniStack.peek();
    }

}
