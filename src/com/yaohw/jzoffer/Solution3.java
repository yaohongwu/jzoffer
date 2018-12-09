package com.yaohw.jzoffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * User: 姚宏武
 * Date: 2018/12/9
 * Time: 21:05
 * Email：401369870@qq.com
 * Description: 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * 解题思路1：利用栈先进后出的特性。
 * 阶梯思路2：将链表节点值逆序添加进数组，然后逐个保存到ArrayList中
 */
public class Solution3 {


    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ArrayList<Integer> arrayList = printListFromTailToHead1(listNode1);
        System.out.println(arrayList);
    }

    /**
     * 从尾到头打印链表
     *
     * @param listNode 相当于头结点
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrays = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        ListNode temp = listNode;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            arrays.add(stack.pop());
        }
        return arrays;
    }

    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> arrays = new ArrayList<>();
        ListNode temp = listNode;
        while (temp != null) {
            arrays.add(temp.val);
            temp = temp.next;
        }
        Integer[] arr = new Integer[arrays.size()];
        for (int i = arrays.size() - 1, j = 0; i >= 0; i--, j++) {
            arr[j] = arrays.get(i);
        }
        arrays.clear();
        for (int i = 0; i < arr.length; i++) {
            arrays.add(arr[i]);
        }
        return arrays;
    }

}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}