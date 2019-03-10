package org.sojournerhhy.petrichor.algorithm.school_recruitment_2017;

import java.util.Scanner;

/**
 * Description: 合唱团
 *
 * @author 陌北有棵树
 * @version 2019/3/6
 */
public class Choir {

    /*
        题目描述
        有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，
        使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？

        输入描述:
        每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，表示学生的个数，
        接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
        接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。

        输出描述:
        输出一行表示最大的乘积。

        输入
        3
        7 4 7
        2 50


        输出
        49
        */


    public static long choir(int n, int[] arr, int k, int d) {

        long dp[][] = new long[n + 1][k + 1];

        // n个选k个能力值乘积的最小值数组
        long g[][] = new long[n + 1][k + 1];

        long result = Long.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            dp[i][1] = arr[1];
            g[i][1] = arr[1];
        }

        for (int i = 2; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                long max = Long.MAX_VALUE;
                long min = Long.MIN_VALUE;

                for (int left = Math.max(k - 1, j - d); left <= j - 1; left++) {
                    if (max < Math.max(dp[left][i - 1] * arr[j], g[left][i - 1] * arr[j])) {
                        max = Math.max(dp[left][i - 1] * arr[j], g[left][i - 1] * arr[j]);
                    }
                    if (min > Math.min(dp[left][i - 1] * arr[j], g[left][i - 1] * arr[j])) {
                        min = Math.min(dp[left][i - 1] * arr[j], g[left][i - 1] * arr[j]);
                    }
                    dp[j][i] = max;
                    g[j][i] = min;
                }

            }
            for (i = k; i <= n; i++) {
                if (result < dp[i][k]) {
                    result = dp[i][k];
                }
            }
            System.out.println(result);
        }
        return result;

    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                arr[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();
            int d = scanner.nextInt();
            System.out.println(choir(n, arr, k, d));



        }

    }
}



