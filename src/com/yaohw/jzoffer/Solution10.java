package com.yaohw.jzoffer;

/**
 * User: 姚宏武
 * Date: 2018/12/13
 * Time: 21:09
 * Email：401369870@qq.com
 * Description: 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 解题思路：
 * 当n<=0时，直接返回0
 * 当n=1时，1种摆法
 * 当n=2时，2种摆法
 * 当n=3时，3种摆法
 * 当n=4时，5种摆法
 * ...
 * 斐波那契数列
 */
public class Solution10 {

    /**
     * 递归解法（递归解法耗时比较长）
     *
     * @param target 目标数
     * @return
     */
    public static int RectCover(int target) {

        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

    public static int rectCover(int target) {

        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        // a b f
        //   a b f
        int a = 1;
        int b = 2;
        int f = 0;
        for (int i = 3; i <= target; i++) {
            f = a + b;
            a = b;
            b = f;
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(rectCover(5));
    }
}
