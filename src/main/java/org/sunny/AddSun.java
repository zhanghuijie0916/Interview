package org.sunny;

import java.util.Scanner;

public class AddSun {
    /**
     * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
     * 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
     输入描述:输入为两行: 第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000) 第二行为n个正整数A[i](32位整数)，以空格隔开。
     输出描述:输出所求的方案数.
     */

    /**
     * 链接：https://www.nowcoder.com/questionTerminal/7f24eb7266ce4b0792ce8721d6259800
     来源：牛客网

     动态规划算法。dp[i][j]代表用前i个数字凑到j最多有多少种方案。
     dp[i][j]=dp[i-1][j];   //不用第i个数字能凑到j的最多情况
     dp[j][j]+=dp[i-1][j-value[i]];  //用了i时，只需要看原来凑到j-value[i]的最多情况即可。并累加
     dp[0]=1;  //初始化，表示凑到0永远有1种方案。
     按01背包的思路写循环即可
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = in.nextInt();
        int[] value = new int[n];
        long[] dp = new long[sum + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            value[i] = in.nextInt();
            for (int j = sum; j >= 0; j--) {
                if (j >= value[i]) {
                    dp[j] += dp[j - value[i]];
                }
            }
        }
        System.out.println(dp[sum]);

    }
}
