package org.sunny;


import java.util.*;
public class LastPerson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入人的个数n:");
        int n = sc.nextInt();
        fun(n);
        sc.close();
    }

    private static void fun(int n) {
        boolean[] ps = new boolean[n];
        int count = ps.length; //判断是否是最后一个
//开始都有人，初始化为true
        for (int i = 0; i < ps.length; i++) {
            ps[i] = true;
        }
//数到3剔除
        for(int i = 0,j = 0;;i++){
            if(ps[i]){
                j++;
                if(j == 3){
                    ps[i] = false;
                    j=0;
                    count --; //剔除一人少一人
                }
            }
//从开始继续循环
            if(i == ps.length -1){
                i = -1;
            }
            if(count == 1){
                break; //最后一个人退出循环
            }
        }

//输出最后存在的那个人
        for (int i = 0; i < ps.length; i++) {
            if(ps[i]){
                System.out.println("最后剩下的人的编号是：" + (i+1));
            }
        }
    }
}
