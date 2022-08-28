package com.huster.leetcode.prepareForOffer;

/**
 * @author Created by Divo
 * @date 2020/9/7
 * Description:自动拆箱和自动装箱
 * Status:finished
 * 装箱valueOf
 * 拆箱xxvalue
 * see more details click<href>https://www.cnblogs.com/dolphin0520/p/3780005.html<href/>
 */
public class AutoBoxing {
    public static void main(String[] args) {

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c == d); //true

        System.out.println(e == f);  //false

        System.out.println(c == (a + b)); //true

        System.out.println(c.equals(a + b)); //true

        System.out.println(g == (a + b)); //true

        System.out.println(g.equals(a + b)); //false

        System.out.println(g.equals(a + h));  //true


        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1 == i2); //true
        System.out.println(i3 == i4); //false

        Double i11 = 100.0;
        Double i22 = 100.0;
        Double i33 = 200.0;
        Double i44 = 200.0;

        System.out.println(i11 == i22);  //false
        System.out.println(i33 == i44);  //false
    }
}
