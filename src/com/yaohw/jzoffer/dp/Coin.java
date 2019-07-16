package com.yaohw.jzoffer.dp;

/**
 * User: 姚宏武
 * Date: 2019/7/10
 * Time: 22:47
 * Email：401369870@qq.com
 * Description: 题目：给你k种面值的硬币，面值分别为c1,c2,...,ck,在给你一个总金额n，
 * 问你最少需要几枚硬币可以凑出这个金额，如果不能凑出，则回答-1。
 */
public class Coin {

    private static int amount = 2;
    private static int[] coins = {1, 2, 5};
    private static int k = 3;

    public static void main(String[] args) {

        int i = coinChange1(coins, amount);
        System.out.println(i);
    }

    private static int coinChange1(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        int ans = amount + 1;
        for (int coin : coins) {
            if (amount - coin < 0) {
                continue;
            }
            int subProb = coinChange1(coins, amount - coin);
            if (subProb == -1) {
                continue;
            }
            ans = Math.min(ans, subProb + 1);
        }


        return ans == amount ? -1 : ans;
    }


}
