package myInterview;

import java.util.Arrays;
import java.util.Scanner;

public class KuaiShou2 {
    public static int countways(int n,int[] dp){
        if (n<0){
            return 0;
        }
        if (n==0){
            return 1;
        }
        else {
            int c =0;
            for (int a : dp){
                c += countways(n-a,dp) % (Math.pow(10,9)+3);
            }
            return c;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
//        int arr[] = {1,5,10,20,50,100};
        while (num>0){
            num--;
            int n = in.nextInt();
            int jie = (int)(Math.log(n)/Math.log(2));
            int[] arr = new int[jie+1];
            for (int i=0;i<=jie;i++){
                arr[i] = (int)Math.pow(2,i);
            }
//            System.out.println("array:"+Arrays.toString(arr));

            /*long res[] = new long[n+1];
            res[0] = 1L;

            for(int i=0; i<arr.length; i++){
                for(int j=1; j<=n; j++){
                    if(j >= arr[i]){
                        res[j] += res[j-arr[i]]%(Math.pow(10,9)+3);
                    }
                }
            }*/

            System.out.println(countways(n,arr));
        }
    }
}
