package org.sunny;

import java.util.Scanner;


public class BornRabbit {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            int[] arr = new int[N];
            int sum = 0;
            for(int i = 0; i < N; i++){
                int t = in.nextInt();
                sum = sum + t;
                arr[i] = t;
            }
            int averge = sum / N;
            if(sum % N != 0){
                System.out.println(-1);
                return;
            }
            int result = 0;
            for(int n : arr){
                if(n > averge){
                    int temp = n - averge;
                    if(temp % 2 != 0){
                        System.out.print(-1);
                        return;
                    }else {
                        result += temp / 2;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
