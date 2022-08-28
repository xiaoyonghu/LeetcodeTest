package com.huster.leetcode.prepareForOffer;

/**
 * @author Created by Divo
 * @date 2020/9/7
 * Description: == 与 equals 方法的测试
 * == : 它的作用是判断两个对象的地址是不是相等。
 * 即，判断两个对象是不是同一个对象(基本数据类型==比较的是值，引用数据类型==比较的是内存地址)。
 * Status:finished
 */
public class equalsMethod {
    public static void main(String[] args) {
        String a = new String("ab");
        String b = new String("ab");
        String aa = "ab";  // 放在常量池中
        String bb = "ab";  //从常量池中找
        if (a == b) {  //false
            System.out.println("a == b");
        }
        if (aa == bb) {  //true
            System.out.println("aa == bb");
        }

        if (a.equals(b)) { //String 重写了equals方法
            System.out.println("a.equals(b)");

        }
        if (42 == 42.0) { //隐性转换
            System.out.println("42转换为42.0成功");
        }
    }
}
