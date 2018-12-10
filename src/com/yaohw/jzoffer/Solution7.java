package com.yaohw.jzoffer;

/**
 * User: 姚宏武
 * Date: 2018/12/10
 * Time: 21:43
 * Email：401369870@qq.com
 * Description: 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * 解题思路：当n大于2时，后一项等于前两项之和。1 1 2 3 5 8 13 21 34 55 ...
 */
public class Solution7 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(10));
    }

    public static int Fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        int[] a = new int[n];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i < n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n - 1];
    }
}
