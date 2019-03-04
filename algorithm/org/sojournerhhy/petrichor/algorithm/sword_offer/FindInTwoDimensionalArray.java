package org.sojournerhhy.petrichor.algorithm.sword_offer;

/**
 * Description: 二维数组中的查找
 *
 * @author 陌北有棵树
 * @version 2019/3/3
 */
public class FindInTwoDimensionalArray {

    /*
    给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。

    Consider the following matrix:
    [
        [1,   4,  7, 11, 15],
        [2,   5,  8, 12, 19],
        [3,   6,  9, 16, 22],
        [10, 13, 14, 17, 24],
        [18, 21, 23, 26, 30]
    ]

    Given target = 5, return true.
    Given target = 20, return false.
    */

    private static boolean Find(int target, int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        int r = 0, c = col - 1;
        while (r <= row - 1 && c >= 0) {
            if (target == matrix[r][c]) {
                return true;
            } else if (target > matrix[r][c]) {
                r++;
            }else {
                c--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{2,5,5,6},{1,1,1,1},{3,2,4,1},{1,7,5,9}};
        int tar = 9;
        System.out.println(Find(tar, arr));
    }
}
