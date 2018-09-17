package org.sunny;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 一个数组Array，如果A[i]>A[i+1]>A[i+2]或者A[i]<A[i+1]<A[i+2],则这个数组不是一个zigzag数组，
 * 问去除掉最少几位，可以让这个数组变成zigzag数组。
 * 思路：有这种情况就去除点中间一位。
 */
public class ZigZagArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            list.add(scan.nextInt());
        }

        boolean flag = true;
        int c =0;
        while (flag){

            flag = false;
            for (int i=0;i<list.size()-2;i++){
                int a1 = list.get(i);
                int a2 = list.get(i+1);
                int a3 = list.get(i+2);
                if (a1>a2 && a2>a3){
                    c++;
                    flag = true;
                    list.remove(i+1);
                }
                else if (a1<a2 && a2<a3){
                    c++;
                    flag = true;
                    list.remove(i+1);
                }
            }
        }

        System.out.println(c);
        //list.forEach(x->System.out.println(x));


    }
}
