package org.sojournerhhy.petrichor.algorithm.sword_offer;

/**
 * Description: 数组中重复的数字
 *
 * @author 陌北有棵树
 * @version 2019/3/3
 */
public class DuplicatesInArray {
    /*在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
    Input:
    {2, 3, 1, 0, 2, 5}
    Output:
    2
    */

    private static boolean duplicate(int[] nums, int length, int[] duplicate) {
        if (nums == null || length < 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplicate[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] array = {2, 3, 1, 0, 2, 5};
        int[] dup = new int[array.length];
        System.out.println(duplicate(array, array.length, dup));
        System.out.println(dup[0]);

    }

}
