package myInterview;

import java.util.Scanner;

public class Tujia2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();
        while (test-->0){
            int n = in.nextInt();
            int k = in.nextInt();
            if (n%(k+1)==0){
                System.out.println("B");
            }else {
                System.out.println("A");
            }
        }
    }
}
