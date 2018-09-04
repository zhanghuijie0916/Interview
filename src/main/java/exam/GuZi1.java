package exam;

import java.util.*;
public class GuZi1 {
//    /*public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String[] ss = str.split(" ");
//        StringBuilder build = new StringBuilder();
//        for (int i=ss.length-1;i>0;i--){
//            build.append(ss[i]+" ");
//        }
//        build.append(ss[0]);
//        System.out.println(build.toString());
//    }*/
public static void recursionArrange(char[] arrayA,int start,int end){
    if(end <= 1)
        return;
    if(start == end){
        for(int i = 0;i < arrayA.length;i++)
            System.out.print(arrayA[i]);
        System.out.println();
    }
    else{
        for(int i = start;i <= end;i++){
            swap(arrayA,i,start);
            recursionArrange(arrayA,start+1,end);
            swap(arrayA,i,start);
        }
    }

}
    //交换数组m位置和n位置上的值
    public static void swap(char[] arrayA,int m,int n){
        char temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        char[] arrayA = A.toCharArray();
        recursionArrange(arrayA,0,arrayA.length-1);
    }

}
