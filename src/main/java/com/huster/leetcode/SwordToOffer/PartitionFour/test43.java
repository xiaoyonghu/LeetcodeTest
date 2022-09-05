package com.huster.leetcode.SwordToOffer.PartitionFour;

/**
 * @author Yongshao
 * @Date 2022/8/28
 * Description: 1～n 整数中 1 出现的次数
 * <p>
 * 类似于生活中的密码锁，固定一位转动其他位
 * 看的别人的解答（找规律题）
 */
public class test43 {
    public int countDigitOne(int n) {
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        int digit = 1;
        int res = 0;
        while (high != 0 || cur != 0) {
            // res add count action
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += high * digit + digit;

            // do variable operation
            low += cur * digit; //将 cur 加入 low ，组成下轮 low
            cur = high % 10;  //下轮 cur 是本轮 high 的最低位
            high = high / 10;  //将本轮 high 最低位删除，得到下轮 high
            digit *= 10;  //位因子每轮 × 10
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
