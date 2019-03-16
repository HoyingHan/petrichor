package org.sojournerhhy.petrichor.algorithm.search;

/**
 * Description: 二分查找
 *
 * @author 陌北有棵树
 * @version 2019/3/16
 */
public class BinarySearch {

    public static int binarySearchNonRecursive(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int key, int start, int end) {
        int mid = start + (end - start) / 2;
        if (key == arr[mid]) {
            return mid;
        }
        if (end <  start) {
            return -1;
        } else if (key < arr[mid]) {
            return binarySearchRecursive(arr, key, start, mid - 1);
        }else {
            return binarySearchRecursive(arr, key, mid + 1, end);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 7, 8, 9};
        System.out.println(binarySearchRecursive(arr, 3, 0, arr.length - 1));
        System.out.println(binarySearchNonRecursive(arr, 3));

    }
}
