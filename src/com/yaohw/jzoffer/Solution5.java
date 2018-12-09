package com.yaohw.jzoffer;

import java.util.Stack;

/**
 * User: 姚宏武
 * Date: 2018/12/9
 * Time: 21:56
 * Email：401369870@qq.com
 * Description: 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 解决思路：
 *      入队：将元素进栈A
 *      出队：判断栈B是否为空，如果为空，则将栈A中所有元素pop，并push进栈B，栈B出栈；如果不为空，栈B直接出栈
 */
public class Solution5 {

    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(pop());
        }
    }

    public static void push(int node) {
        stack1.push(node);
    }

    public static int pop() {
        Integer i;                      // 接收出栈的值
        if (stack2.empty()) {           // stack2为空时，将stack1的所有元素全部出栈并入栈到找stack2
            while (!stack1.empty()) {
                i = stack1.pop();
                stack2.push(i);
            }
        }
        i = stack2.pop();               // 若stack2不为空，直接出栈
        return i;
    }
}
