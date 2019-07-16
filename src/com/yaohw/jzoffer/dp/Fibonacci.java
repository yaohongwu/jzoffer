package com.yaohw.jzoffer.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 姚宏武
 * Date: 2019/7/10
 * Time: 21:36
 * Email：401369870@qq.com
 * Description: 斐波那契数列，1 1 2 3 5 8
 */
public class Fibonacci {
    private static int n = 40;
    private static Map<Integer, Long> map = new HashMap<>();

    public static void main(String[] args) {

        long start1 = System.currentTimeMillis();
        long j = Fibonacci1(n);
        System.out.println("Fibonacci1:" + j);
        System.out.println("耗时：" + (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        long i = Fibonacci2(n);
        System.out.println("Fibonacci2:" + i);
        System.out.println("耗时：" + (System.currentTimeMillis() - start2));
        long start3 = System.currentTimeMillis();
        long k = Fibonacci3(n);
        System.out.println("Fibonacci3:" + k);
        System.out.println("耗时：" + (System.currentTimeMillis() - start3));
        long start4 = System.currentTimeMillis();
        long p = Fibonacci4(n);
        System.out.println("Fibonacci4:" + p);
        System.out.println("耗时：" + (System.currentTimeMillis() - start4));

    }

    /**
     * 分析斐波那契数列，只需要知道前两个子问题的解，并不需要保存所有子问题的解
     * 时间复杂度O(n),空间复杂度O(1)
     *
     * @param n 问题的参数
     * @return 问题的解
     */
    private static long Fibonacci4(int n) {
        if (n < 2) {
            return n;
        }
        long prev = 0;
        long curr = 1;
        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    /**
     * 动态规划，构建一张DP table，自底向上求解
     * 时间复杂度为O(n),空间复杂度为O(n)
     *
     * @param n 子问题的参数
     * @return 子问题的解
     */
    private static long Fibonacci3(int n) {
        Map<Integer, Long> m = new HashMap<>();
        m.put(1, 1l);
        m.put(2, 1l);
        for (int i = 3; i <= n; i++) {
            m.put(i, m.get(i - 1) + m.get(i - 2));
        }
        return m.get(n);
    }

    /**
     * 采用备忘录记录子问题的解，避免重复计算
     * 时间复杂度为O(n),空间复杂度为O(n)
     *
     * @param n 子问题参数
     * @return 子问题的解
     */
    private static long Fibonacci2(int n) {

        map.put(1, 1l);
        map.put(2, 1l);
        for (int i = 3; i <= n; i++) {
            map.put(i, 0l);
        }
        return helper(map, n);
    }


    /**
     * 递归解法（增加了备忘录），自顶向下求解
     *
     * @param map 备忘录
     * @param n   子问题参数
     * @return 子问题的解
     */
    private static long helper(Map<Integer, Long> map, int n) {
        if (map.get(n) == 0) {
            map.put(n, helper(map, n - 1) + helper(map, n - 2));
        }
        return map.get(n);
    }


    /**
     * 递归解法（暴力法）,自顶向下求解，存在大量重复计算
     * 时间复杂度为O(2^n)
     *
     * @param n 问题参数
     * @return 问题解
     */
    private static long Fibonacci1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci1(n - 1) + Fibonacci1(n - 2);

    }


}
