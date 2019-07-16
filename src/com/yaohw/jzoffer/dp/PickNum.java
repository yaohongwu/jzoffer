package com.yaohw.jzoffer.dp;

/**
 * User: 姚宏武
 * Date: 2019/7/13
 * Time: 16:08
 * Email：401369870@qq.com
 * Description: 一组数字，挑选互不相邻的数字，保证得到的和最大。
 */
public class PickNum {

    static int[] arr = {1, 2, 4, 1, 7, 8, 3};

    public static void main(String[] args) {

        int opt = rec_opt(arr, arr.length - 1);
        System.out.println(opt);
        int opt1 = dp_opt(arr);
        System.out.println(opt1);

    }

    /**
     * 递归的解法
     * @param arr 一组数据
     * @param i 第i个数字
     * @return 和最大的解
     */
    private static int rec_opt(int[] arr, int i) {

        if (i == 0) {
            return arr[0];
        } else if (i == 1) {
            return Math.max(arr[0], arr[1]);
        } else {
            // 选择第i个数字
            int a = arr[i] + rec_opt(arr, i - 2);
            // 不选择第i个数字
            int b = rec_opt(arr, i - 1);
            return Math.max(a, b);
        }
    }

    /**
     * 动态规划思想，造表
     * @param arr 一组数据
     * @return 和最大的解
     */
    private static int dp_opt(int[] arr) {

        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        int A, B;
        for (int i = 2; i < arr.length; i++) {
            A = opt[i - 2] + arr[i];// 选arr[i]
            B = opt[i - 1];// 不选arr[i]
            opt[i] = Math.max(A, B);
        }

        return opt[arr.length - 1];
    }

}
