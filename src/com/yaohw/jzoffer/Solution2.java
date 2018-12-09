package com.yaohw.jzoffer;

/**
 * User: 姚宏武
 * Date: 2018/12/9
 * Time: 20:43
 * Email：401369870@qq.com
 * Description: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution2 {

    /**
     * 替换空格
     *
     * @param str 目标字符串
     * @return
     */
    public static String replaceSpace(StringBuffer str) {

        StringBuffer buffer = new StringBuffer();
        char[] chars = str.toString().toCharArray();
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == ' ') {
                buffer.append("%20");
            } else {
                buffer.append(chars[i]);
            }
            i++;
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String str = "We Are Happy";
        System.out.println(replaceSpace(new StringBuffer(str)));
    }
}
