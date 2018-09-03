package org.sunny;

import java.util.Scanner;

/**
 * 有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
 输入描述:
 输入包括一行，逗号隔开的两个正整数x和y，取值范围[1,10]。
 输出描述:
 输出包括一行，为走法的数目。
 */
public class Grid {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] arr = new int[x + 1][y + 1];
        for (int i = 0; i <= x; i++) {
            arr[i][0] = 1;
        }
        for (int i = 0; i <= y; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= y; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        System.out.println(arr[x][y]);
        sc.close();
    }
}