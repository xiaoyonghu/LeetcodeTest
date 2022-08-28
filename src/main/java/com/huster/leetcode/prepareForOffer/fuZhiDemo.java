package com.huster.leetcode.prepareForOffer;

/**
 * @author Created by Divo
 * @date 2020/10/29
 * Description: 用来测试 成员变量和局部变量
 * Status:new
 */
public class fuZhiDemo {

    int j;  //成员变量，不需要显示赋值 属于类或者实例
    final int a = 0;  //final修饰的变量必须被显示赋值

    static int b = 1;

    public boolean areYouOk(String s) {  //方法参数也是局部变量
        int i = 0;    //必须显示赋值，局部变量不能自动赋值
        //public int k = 0;   不能使用修饰符
        final int k = 0;  // 可以使用final

        int ss = b; //可以访问 静态变量

        //System.out.println(i);
        return false;
    }

    public static boolean staOperation1() {
        int ss;  //非静态
        final int ssss = 1;
        //static int sss;  ss为局部变量 ，不能使用修饰符 和 static来休息
        //  System.out.println(ss);   ss也是局部变量
        System.out.println(ssss);
        return false;
    }

    public static boolean staOperation2() {
        staOperation1(); //访问静态方法
        // areYouOk();  不能访问非静态方法
        int sss = b;
        // System.out.println( a);   不能访问 非静态方法
        return false;
    }
    
    public static void main(String[] args) {
        fuZhiDemo fuZhiDemo = new fuZhiDemo();
        fuZhiDemo.areYouOk("rfer");
    }
}
