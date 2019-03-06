package org.sojournerhhy.petrichor.algorithm.common.utils;

import org.sojournerhhy.petrichor.algorithm.common.object.ListNode;

/**
 * Description: 链表工具类
 *
 * @author 陌北有棵树
 * @version 2019/3/6
 */
public class LinkedListUtil {


    /**
     * 随机生成长度为length的链表
     * @param length 长度
     * @return 头结点
     */
    public static ListNode buildLinkedListAddLastNode(int length) {

        ListNode virtualHead = new ListNode(10000);
        ListNode cur = virtualHead;
        for (int i = 0; i < length; i++) {
            int value = (int) (Math.random() * 10 + 1);
            ListNode newNode = new ListNode(value);
            cur.setNext(newNode);
            cur = newNode;
        }
        return virtualHead.getNext();
    }




    /**
     * 打印链表
     * @param head
     */
    public static void printLinkedList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.getNext() == null) {
                System.out.print(cur.getVal());
            }else {
                System.out.print(cur.getVal() + " -> ");
            }
            cur = cur.getNext();
        }
    }





    public static void main(String[] args) {
        ListNode head = buildLinkedListAddLastNode(5);
        printLinkedList(head);

    }






}
