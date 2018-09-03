package org.sunny;

/**
 * 现在有一个数组，其值为从1到10000的连续增长的数字。出于某次偶然操作，导致这个数组中丢失了某三个元素，同时顺序被打乱，现在需要你用最快的方法找出丢失的这三个元素，并且将这三个元素根据从小到大重新拼接为一个新数字，计算其除以7的余数。 例：丢失的元素为336，10，8435，得到的新数字为103368435，除以七的余数为2。
 输入描述:
 输入数据为一行，包含9997个数字，空格隔开。
 输出描述:
 输出为一行，包含一个数字。
 */

import java.util.Scanner;
import java.util.Arrays;

public class Find {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] arr = new boolean[10000];
        int len = arr.length - 3;
        for(int i = 0; i < len; i++) {
            int j = sc.nextInt();
            arr[j - 1] = true;
        }
        int[] dp = new int[3];
        int n = 0;
        for(int i = 0; i < arr.length; i++) {
            if(!arr[i]) {
                dp[n++] = i + 1;
            }
        }
        Arrays.sort(dp);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++) {
            sb.append(dp[i]);
        }
        long result =  Long.parseLong(sb.toString());
        result %= 7;
        System.out.println(result);
        sc.close();
    }
}