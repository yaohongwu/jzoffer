package com.yaohw.jzoffer.dp;

/**
 * User: 姚宏武
 * Date: 2019/7/15
 * Time: 22:44
 * Email：401369870@qq.com
 * Description: 一组数据，给定一个result,判断这组数据中是否存在一个子集的和正好等于result
 * 此题也为选与不选的思路。
 * 选：subset(arr,i - 1,result - arr[i])
 * 或
 * 不选：subset(arr,i - 1,result)
 * 选与不选，只要有一个满足就说明存在一个子集的和等于result
 */
public class PickNum1 {

    public static void main(String[] args) {

        int[] arr = {3, 34, 4, 12, 5, 2};
        System.out.println(rec_subset(arr, arr.length - 1, 9));
        System.out.println(rec_subset(arr, arr.length - 1, 10));
        System.out.println(rec_subset(arr, arr.length - 1, 11));
        System.out.println(rec_subset(arr, arr.length - 1, 12));
        System.out.println(rec_subset(arr, arr.length - 1, 13));


        System.out.println(dp_subset(arr, 9));
        /*System.out.println(dp_subset(arr, 10));
        System.out.println(dp_subset(arr, 11));
        System.out.println(dp_subset(arr, 12));
        System.out.println(dp_subset(arr, 13));*/

    }

    /**
     * 递归求解法
     *
     * @param arr    问题的数据集
     * @param i      子问题的剩余元素的最后一个值的下标
     * @param result 子问题的result
     * @return 是否存在这样的子集
     */
    private static boolean rec_subset(int[] arr, int i, int result) {
        if (result == 0) { // 如果result值为0，返回true，空集也是一组数据的子集
            return true;
        } else if (i == 0) { // 如果已经找到第0个元素，且此时arr[0] == result，说明存在这样的子集
            return arr[0] == result;
        } else if (arr[i] > result) { // 如果arr[i]的值已经大于result，则跳过这个数，进入不选的分支
            return rec_subset(arr, i - 1, result);
        } else {
            // 选择第i个数，递归求解剩余i - 1个数
            boolean A = rec_subset(arr, i - 1, result - arr[i]);
            // 不选第i个数，递归求解剩余i - 1个数
            boolean B = rec_subset(arr, i - 1, result);
            // 返回A 或 B,只要有一个满足，说明存在这样的子集
            return A | B;
        }

    }


    /**
     * 动态规划（造表）
     *  false false false true false false false false false false
     *  true false false true false false false false false false
     *  true false false true true false false true false false
     *  true false false true true false false true false false
     *  true false false true true true false true true true
     *  true false true true true true true true true true
     *
     * @param arr 数据集
     * @param result 目标值
     * @return 是否存在一个子集的和等于原目标值
     */
    private static boolean dp_subset(int[] arr, int result) {
        boolean[][] subset = new boolean[arr.length][result + 1];
        for (int i = 0; i < subset.length; i++) {
            for (int r = 0; r < result + 1; r++) {
                subset[i][0] = true;
                subset[0][r] = false;
                subset[0][arr[0]] = true;
            }
        }


        for (int i = 1; i < subset.length; i++) {
            for (int r = 1; r < result + 1; r++) {
                if (arr[i] > r) {
                    subset[i][r] = subset[i - 1][r];
                } else {
                    /*boolean a = subset[i - 1][r - arr[i]];
                    boolean b = subset[i - 1][r];
                    subset[i][r] = a | b;*/
                    // 此处利用||运算符的短路功能可以剪枝
                    subset[i][r] = subset[i - 1][r - arr[i]] || subset[i - 1][r];
                }
            }
        }

        for (int i = 0; i < subset.length; i++) {
            for (int r = 0; r < result + 1; r++) {
                System.out.print(subset[i][r] + " ");
            }
            System.out.println();
        }


        // 返回subset数组的右下角的值
        return subset[arr.length - 1][result];

    }


}
