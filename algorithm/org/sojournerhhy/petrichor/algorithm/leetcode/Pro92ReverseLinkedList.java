package org.sojournerhhy.petrichor.algorithm.leetcode;

import org.sojournerhhy.petrichor.algorithm.common.object.ListNode;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/5
 */
public class Pro92ReverseLinkedList {


    public static ListNode reverseBetweenMToN(ListNode head, int m, int n) {
        int count = 0;
        ListNode virtualNode = new ListNode(100);
        virtualNode.setNext(head);
        ListNode current = virtualNode;
        ListNode pre = null;
        ListNode preOne = null;
        ListNode nextOne = null;

        while (count <= n) {
            while (count <= m - 1) {
                preOne = current;
                current = current.getNext();
                count++;
                nextOne = current;
            }

        }
        return null;

    }

    public static void main(String[] args) {

    }


}
