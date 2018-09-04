package org.sunny;


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，
 要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
 输入描述:
 每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，
 表示学生的个数，接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
 接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
 输出描述:
 输出一行表示最大的乘积。

 */
public class MaxPrice {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] valuesArray = new int[N+1];
        for (int i=0;i<N;i++){
            valuesArray[i+1] = scanner.nextInt();
        }
        int K = scanner.nextInt();
        int D = scanner.nextInt();

        long[][] maxDp = new long[N+1][K+1];
        long[][] minDp = new long[N+1][K+1];
        for (int i=1;i<=N;i++){
            maxDp[i][1] = valuesArray[i];
            minDp[i][1] = valuesArray[i];
        }

        for (int k=2;k<=K;k++){
            //一定包含last
            for (int last=k;last<=N;last++){
                long tempMax = Long.MIN_VALUE;
                long tempMin = Long.MAX_VALUE;
                for (int left=Math.max(k-1,last-D);left<last;left++){
                    tempMax = Math.max(tempMax,Math.max(maxDp[left][k-1]*valuesArray[last],minDp[left][k-1]*valuesArray[last]));
                    tempMin = Math.min(tempMin,Math.min(maxDp[left][k-1]*valuesArray[last],minDp[left][k-1]*valuesArray[last]));
                }

                maxDp[last][k] = tempMax;
                minDp[last][k] = tempMin;
            }
        }

        /*for (int i=0;i<=N;i++){
            System.out.println(Arrays.toString(maxDp[i]));
        }*/

        long maxResult = Long.MIN_VALUE;
        for (int i=K;i<=N;i++){
            maxResult = Math.max(maxResult,maxDp[i][K]);
        }

        System.out.println(maxResult);






    }
}
