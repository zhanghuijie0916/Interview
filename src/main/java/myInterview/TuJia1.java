package myInterview;

import java.util.Scanner;

public class TuJia1 {
    /**
     * 求两个数的最大公约数
     */
    public static int gcd(int m,int n){
        while (n!=0){
            int r = m%n;
            m = n;
            n = r;
        }
        return m;
    }

    /**
     * 求两个数的最小公倍数
     */
    public static int commonMultiple(int n, int m) {// 求两个数的最小公倍数
        // 两个数相乘等于这两个数的最大公约数和最小公倍数的积。
        return n * m / gcd(n, m);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int a=gcd(m,n);
        int b = commonMultiple(m,n);
        System.out.println(a);
        System.out.println(b);
    }
}
