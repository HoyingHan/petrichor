package org.sojournerhhy.petrichor.algorithm.leetcode;

import org.sojournerhhy.petrichor.algorithm.common.object.ListNode;
import org.sojournerhhy.petrichor.algorithm.common.utils.LinkedListUtil;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/6
 */
public class Pro206ReverseLinkedList {


    public static ListNode reverseList(ListNode head){

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            cur = next;
        }

        return pre;
    }


    public static void main(String[] args) {
        ListNode head = LinkedListUtil.buildLinkedListAddLastNode(5);
        LinkedListUtil.printLinkedList(head);
        ListNode curr = reverseList(head);
        System.out.println();
        LinkedListUtil.printLinkedList(curr);
    }
}
