package exam;

import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;

import java.util.*;
public class GuZi2 {

    public static void recursionArrange(char[] arrayA,int start,int end){
        if(end <= 1)
            return;
        if(start == end){
            String s = "";
            for(int i = 0;i < arrayA.length;i++){
                s = s+arrayA[i];
            }
             result.add(s);

//                System.out.print(arrayA[i]);

//            System.out.println();
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

    private static Set<String> result = new HashSet<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        int num = sc.nextInt();
        String s = "";
        for (int i=0;i<num;i++){
            s = sc.nextLine();
            set.add(s);
        }

        char[] arrayA = s.toCharArray();
        recursionArrange(arrayA,0,arrayA.length-1);

        result.removeAll(set);
        result.forEach(x ->System.out.println(x));

    }


}
