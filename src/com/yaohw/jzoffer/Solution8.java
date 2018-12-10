package com.yaohw.jzoffer;

/**
 * User: 姚宏武
 * Date: 2018/12/10
 * Time: 21:58
 * Email：401369870@qq.com
 * Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Solution8 {
    public static void main(String[] args) {
        System.out.println(JumpFloor(10));
    }

    /**
     * 跳台阶
     * @param target 目标台阶数
     * @return
     */
    public static int JumpFloor(int target) {
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        int[] a = new int[target];
        a[0] = 1;
        a[1] = 2;
        for (int i = 2; i < target; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[target - 1];
    }
}
