package org.sunny;



import java.util.Scanner;

/**
 * 最长度增子序列
 * 链接：https://www.nowcoder.com/questionTerminal/06dbca9614084e9dba9753f99629595c
 来源：牛客网

 给定一个长度为N的数组，找出一个最长的单调自增子序列（不一定连续，但是顺序不能乱）
 例如：给定一个长度为8的数组A{1,3,5,2,4,6,7,8}，则其最长的单调递增子序列为{1,2,4,6,7,8}，长度为6.

 输入描述:
 第一行包含一个整数T，代表测试数据组数。
 对于每组测试数据：
 N-数组的长度
 a1 a2 ... an （需要计算的数组）

 保证：
 1<=N<=3000,0<=ai<=MAX_INT.

 输出描述:对于每组数据，输出一个整数，代表最长递增子序列的长度。
 */
public class MaxGrouthSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = scanner.nextInt();
            }
            int len = getLisLen(array, n);
            System.out.println(len);
        }

        scanner.close();
    }

    public static int getLisLen(int[] array, int n) {
        int[] d = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    d[i] = Integer.max(d[i], d[j]+1);
                }
            }
            max = Integer.max(max, d[i]);
        }
        return max;
    }
}
