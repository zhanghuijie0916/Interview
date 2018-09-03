package org.sunny;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 【拼凑面额】给你六种面额 1、5、10、20、50、100 元的纸币，假设每种币值的数量都足够多，编写程序求组成N元（N为0~10000的非负整数）的不同组合的个数。 

 输入描述:输入包括一个整数n(1 ≤ n ≤ 10000)

 输出描述:输出一个整数,表示不同的组合方案数
 */
public class Coins {
    public static long count(int n) {
        if (n == 0)
            return 0;
        int coins[] = { 1, 5, 10, 20, 50, 100 };
        int h = coins.length;
        long dp[][] = new long[h][n + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < h; i++) {
            for (int j = 1; j <= n; j++) {
                int m = j / coins[i];
                for (int k = 0; k <= m; k++) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j - k * coins[i]];
                }
            }
        }
        return dp[h - 1][n];
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            long res = count(n);
            System.out.println(res);
        }
    }
}
