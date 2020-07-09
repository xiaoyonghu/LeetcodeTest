package com.huster.leetcode.utils;

import org.apache.logging.log4j.util.Chars;

import java.util.*;

/**
 * @author Created by Divo
 * @date 2020/4/8
 * Description:用来练习输入输出
 * Status:new
 */
public class InOutTest {

    //nextInt():用于只读取整型数据，读入空白或空白字符，会跳过，以换行符'\n'结束输入，不包含换行符
    //nextLine():读取整行，包括换行符
    //next()：读取单个单词，以空格作为分隔符



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n=sc.nextInt();
//
//        for (int i = 0; i < n; i++) {
//            int a=sc.nextInt();
//            int b=sc.nextInt();
//            System.out.println("a+b= " +(a+b));
//        }

//        for (;;) {
//            int a=sc.nextInt();
//            int b=sc.nextInt();
//            if (a==0 && b==0)
//                break;
//            else {
//                System.out.println("a+b= " +(a+b));
//            }
//    }

//        while (sc.hasNext()){
//                int n= sc.nextInt();
//                int sum = 0;
//            for (int i = 0; i < n; i++) {
//                int a =sc.nextInt();
//                sum += a;
//            }
//            System.out.println(sum);
//        }
//    }

//        System.out.println("请输入你的姓名");
//        String name = sc.nextLine();//接收一个字符串，可以加除Enter以外的所有符号，包括空格和Tab
        //System.out.println("请输入你的ID");
//        String ID;
//        while (sc.hasNextLine()) {// hasNextLine()方法判断当前是否有输入，当键盘有输入后执行循环
//            if (sc.hasNextInt()) {// 判断输入的值是否为整数类型，当为整数类型时执行循环
//                ID = sc.nextLine();
//                System.out.println("你输入的姓名为：" + name);
//                System.out.println("你输入的ID为：" + ID);
//                break;
//            } else {
//                System.out.println("请输入数字哦！");
//                ID = sc.nextLine();
//                continue;
//            }
//        }

//        int n= sc.nextInt();
//        for (int i = 0; i < n; i++) {
//            int count =sc.nextInt();
//            int sum=0;
//            for (int j = 0; j <count ; j++) {
//                sum+= sc.nextInt();
//            }
//            System.out.println(sum);
//        }



//        int t=sc.nextInt();
//        String[] arr =new String[t];
//        for (int i = 0; i < t; i++) {
//            arr[i]=sc.next();
//        }
//        Arrays.sort(arr);
//        for (int i = 0; i < t; i++) {
//            if (i== t-1){
//                System.out.println(arr[i]);
//            }else {
//                System.out.print(arr[i]+" ");
//            }
//        }

        int c=sc.nextInt();//不知道为什么这里总是冲突
        //用来写字符串的
        for (;sc.hasNextLine(); ) {
            //每次获取一行
            String[] s = sc.nextLine().split(" ");
            Arrays.sort(s);
            for (int i = 0; i < s.length; i++) {
                if (i == s.length - 1) {
                    System.out.println(s[i]);
                } else {
                    System.out.print(s[i] + " ");
                }
            }


            /**
             String s=sc.nextLine();
             // System.out.println(s);
             for (int i = 0; i < s.length(); i++) {
             char c=s.charAt(i);
             if (i == (s.length()-1)){
             System.out.println(c);
             }else {
             System.out.print(c);
             }
             }
             */

            // }
        }
    }
}

