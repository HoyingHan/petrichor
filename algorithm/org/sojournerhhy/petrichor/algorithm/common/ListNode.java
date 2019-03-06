package org.sojournerhhy.petrichor.algorithm.common;

/**
 * Description:
 *
 * @author hanhongying@corp.netease.com
 * @version 2019/3/5
 */
public class ListNode {


    private int val;
    private ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
