package org.sojournerhhy.petrichor.algorithm.greedy;

/**
 * Description:
 *
 * @author 陌北有棵树
 * @version 2019/3/4
 */
public class LongestDistance {


    /* 有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
        给定数组A及它的大小n，请返回最大差值。
        测试样例：
        [10,5],2
        返回：0
    */


    public int getDis(int[] A, int n) {
        // write code here
        int dis = 0;
        if (n > 1) {
            int min = A[0];
            for (int i = 1; i < n; i++) {
                if (A[i] - min > dis) {

                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
