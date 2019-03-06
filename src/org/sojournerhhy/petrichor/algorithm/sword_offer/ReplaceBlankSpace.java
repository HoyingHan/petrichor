package org.sojournerhhy.petrichor.algorithm.sword_offer;

/**
 * Description: 替换空格
 *
 * @author hanhongying@corp.netease.com
 * @version 2019/3/4
 */
public class ReplaceBlankSpace {

    /*将一个字符串中的空格替换成 "%20"。
        Input:
        "A B"

        Output:
        "A%20B"
    */


    private static String replaceSpace(StringBuffer stringBuffer) {
        int p1 = stringBuffer.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (stringBuffer.charAt(i) == ' ') {
                stringBuffer.append("  ");
            }
        }
        int p2 = stringBuffer.length() - 1;
        while (p1 >= 0 && p2 > p1) {
            char c = stringBuffer.charAt(p1--);
            if (c == ' ') {
                stringBuffer.setCharAt(p2--, '0');
                stringBuffer.setCharAt(p2--, '2');
                stringBuffer.setCharAt(p2--, '%');
            }else {
                stringBuffer.setCharAt(p2--, c);
            }
        }
        return stringBuffer.toString();

    }

    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer("A B ");
        System.out.println(replaceSpace(stringBuffer));
    }
}
