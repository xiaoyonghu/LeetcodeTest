package com.huster.leetcode.SwordToOffer.PartitionOne;

/**
 * @author Created by Divo
 * @date 2019/8/19
 * Description:To Do
 * Thought:在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），因
 *         此当遍历到一个空格时，需要在尾部填充两个任意字符
 * Status:new
 */
public class Test5 {
    public String replaceSpcace(StringBuffer str){
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1 ; i++) {
            if (str.charAt(i) == ' ')
                //此处加2个空格
                str.append("  ");
        }
        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1){
            //看符号的位置 ++i(先加后用) i--(先用后减)
            char c = str.charAt( P1-- );
            //从后向前，所以是逆序  规则：%20
            if (c == ' '){
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            }else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Test5 test5 = new Test5();
        StringBuffer stringBuffer=new StringBuffer("we are happy.");
        StringBuffer stringBuffer1=new StringBuffer(" ");
        StringBuffer stringBuffer2=new StringBuffer(" we");
        StringBuffer stringBuffer3=new StringBuffer(" we  ");
        String s = test5.replaceSpcace(stringBuffer3);
        System.out.println(s);
    }
}
