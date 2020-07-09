package com.huster.leetcode.TeachingAssistantTask;

import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Created by Divo
 * @date 2020/4/1
 * Description:To Do
 * Status:new
 */
public class huaweiTest {
    public  int n=0;
    public static ArrayList<String> arrayList=new ArrayList<>();
    public static ArrayList<String> arrayList2=new ArrayList<>();
    public  static String arr[];
   // public static String not_Include[];
    //public static String Include[]={"a","b","AND","OR","NOT"};
    public static Boolean b;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("f");arrayList.add("g");
        arrayList.add("h");arrayList.add("j");arrayList.add("l");arrayList.add("m");arrayList.add("n");
        arrayList.add("o");arrayList.add("p");arrayList.add("q");
        arrayList.add("r");arrayList.add("s");arrayList.add("t");arrayList.add("u");
        arrayList.add("v");arrayList.add("w");arrayList.add("x");arrayList.add("y");
        arrayList.add("z");
        arrayList2.add("AND");
        arrayList2.add("OR");
        arrayList2.add("NOT");

        while(sc.hasNextLine()){
            String s = sc.nextLine();

            arr = StringUtils.split(s," ");
            System.out.println(isOK(arr));
        }
    }
    public  static boolean isOK(String[] arr) {
        boolean flag = true;
            String pre = arr[0];
             System.out.println("执行了");
            for (int i = 1; i < arr.length; i++) {
                System.out.println("执行到了for里面");
                System.out.println(arr.toString());
                if (arrayList.contains(arr[i]) | arrayList2.contains(arr[i])) {
                    System.out.println("3次里面");
                    if ((arrayList.contains(arr[i]) && arrayList.contains(pre)) || (arrayList2.contains(arr[i]) && arrayList2.contains(pre))) {
                        System.out.println("执行到了3");
                        flag = false;
                        break;
                    }
                }
            }
        return flag;
    }

}
