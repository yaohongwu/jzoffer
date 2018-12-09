package com.yaohw.jzoffer;

/**
 * User: 姚宏武
 * Date: 2018/12/9
 * Time: 20:26
 * Email：401369870@qq.com
 * Description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 解决思路：从左下角开始找，当左下角的数小于target时，向上一行找。当左下角的数大于target时，向右找。
 */
public class Solution1 {
    /**
     * 二维数组中的查找
     *
     * @param target 目标值
     * @param array  目标数组
     * @return
     */
    public static boolean Find(int target, int[][] array) {

        int rows = array.length;            // 行数
        int column = array[0].length;       // 列数
        int i = rows - 1;                   // 控制行
        int j = 0;                          // 控制列
        while (i >= 0 && j < column) {      // 此处要注意i的边界值
            if (array[i][j] == target) {
                return true;
            }
            if (array[i][j] < target) {
                j++;
                continue;
            }
            if (array[i][j] > target) {
                i--;
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println(Find(7, a));

    }
}
