package org.sojournerhhy.petrichor.algorithm.programmer_interview_gold;


import org.sojournerhhy.petrichor.algorithm.common.object.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 寻找中序遍历下一个节点
 *
 * @author 陌北有棵树
 * @version 2019/3/6
 */

public class Successor {


    /*
    请设计一个算法，寻找二叉树中指定结点的下一个结点（即中序遍历的后继）。
    给定树的根结点指针TreeNode* root和结点的值int p，请返回值为p的结点的后继结点的值。
    保证结点的值大于等于零小于等于100000且没有重复值，若不存在后继返回-1。
    */

    public static List<TreeNode> list = new ArrayList<TreeNode>();


    public static int findSucc(TreeNode root, int p) {
        find(root);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getVal() == p) {
                return list.get(i + 1).getVal();
            }
        }
        return -1;
    }


    private static void find(TreeNode root) {
        if (root != null) {
            find(root.getLeft());
            list.add(root);
            find(root.getRight());
        }
    }




    public static void main(String[] args) {

       //  System.out.println(findSucc());
    }
}
