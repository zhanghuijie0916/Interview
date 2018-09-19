package exam;

import java.util.Scanner;

/**
 * 生兔子问题，第一个月第二个月不能生，第三个月可以生，生下来这只也是第一、二个月不能生，以此类推。
 */
public class  ChangYou1 {
    public static void main(String[] args) {
        long first = 1;
        long second = 1;
        int count;
        long t;
        Scanner in = new Scanner(System.in);
        count = in.nextInt();
        for (int i = 1; i <= count; i++) {
            if (i == 1 | i==2) {
                continue;
            } else {
                t = second;
                second = first + second;
                first = t;

            }
        }
        System.out.println( second);
    }
}
