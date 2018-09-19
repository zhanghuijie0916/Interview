package exam;

import java.util.Scanner;

public class T3601 {
    public static int fun(int i,int j){
        if(i<=0 || j<=0){
            return 1;
        }
        return 2*fun(i-3,j/2);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x= fun(15,20);
        System.out.println(x
        );
    }
}
