package org.sunny;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/1cca3ac72b8440959d3c0d2f5be88275
 来源：牛客网

 牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
 牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
 牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。

 输入描述:
 输入包括两行
 第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
 第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。


 输出描述:
 输出一个正整数, 表示牛牛一共有多少种零食放法。
 */

import java.util.*;
public class Bag{
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] v = new int[n];
        long sum = 0;
        count = 0;
        for (int i = 0;i < n;i ++){
            v[i] = sc.nextInt();
            sum += v[i];
        }
        if (sum <= w){
            System.out.println((int)Math.pow(2,n));
        }else {
            dfs(0,0,n,v,w);
            System.out.println(count + 1);
        }
    }
    public static void dfs(long cursum,int index,int n,int[] v,int w){
        if (index < n){
            if (cursum > w){
                return;
            }
            //不包含当前零食
            dfs(cursum,index + 1,n,v,w);
            if (cursum + v[index] <= w){
                //包含当前零食，计数+1，当前总数增加
                count ++;
                dfs(cursum + v[index],index + 1,n,v,w);
            }
        }
    }
}