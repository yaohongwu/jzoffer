package com.yaohw.jzoffer.dp;

/**
 * User: 姚宏武
 * Date: 2019/7/13
 * Time: 14:36
 * Email：401369870@qq.com
 * Description:给定一组任务，任务由开始和结束时间，每个任务都有对应的金额，如何做任务才能够使得到的金额最大
 */
public class Task {

    // 任务列表，[开始时间,结束时间]
    static int[][] tasks = {{1, 4}, {3, 5}, {0, 6}, {4, 7}, {3, 8}, {5, 9}, {6, 10}, {8, 11}};
    // 任务对应的金额
    static int[] task_money = {5, 1, 8, 4, 6, 3, 2, 4};
    // 以最后一个任务为参照，如果选择第i个任务后，第i个任务前只能选prev[i]的任务
    // 如果选择了第i个任务，则第i个任务之前能够被选择的任务必须满足条件【第i个任务开始时间，必须大于等于i任务之前能够被选择任务的结束时间】
    static int[] prev = new int[8];

    public static void main(String[] args) {

        prev = init_prev();

        int opt = rec_opt(8);

        System.out.println(opt);
    }

    private static int rec_opt(int index) {
        // 如果一个任务都不选，金额为0
        if (index == 0) {
            return 0;
        }
        // 如果选第一个任务，返回第一个任务对应的金额
        if (index == 1) {
            return task_money[0];
        }

        // 如果选择第index个任务，则金额为第index个任务的金额，加上前序能够选择的第一个任务的金额
        int a = task_money[index - 1] + rec_opt(prev[index - 1]);
        // 如果不选第index个任务，则金额为选第index-1的任务的金额
        int b = rec_opt(index - 1);
        // 返回较大值
        return Math.max(a, b);
    }


    private static int[] init_prev() {
        for (int i = 1; i < 8; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (tasks[i][0] >= tasks[j][1]) {
                    prev[i] = j + 1;
                    break;
                } else {
                    prev[i] = 0;
                }
            }

        }
        return prev;

    }


}
