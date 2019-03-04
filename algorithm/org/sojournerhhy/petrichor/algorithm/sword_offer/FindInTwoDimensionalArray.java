package org.sojournerhhy.petrichor.algorithm.sword_offer;

/**
 * Description: 二维数组中的查找
 *
 * @author 陌北有棵树
 * @version 2019/3/3
 */
public class FindInTwoDimensionalArray {

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
