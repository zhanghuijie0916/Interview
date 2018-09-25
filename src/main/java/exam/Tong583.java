package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Tong583 {
    public static void toArray(String str,String[] splitArr){
        ArrayList<String[][]> list = new ArrayList<>();
        String[] temp = str.split(splitArr[0]);
        for (String s : temp){
            String[] in = s.split(splitArr[1]);
            System.out.println(Arrays.toString(in));
        }
    }

    static void method(){
        try {
            throw new NullPointerException();
        }catch (RuntimeException e){
            System.out.println("run");
        }catch (Exception s){

        }
    }

    public static void main(String[] args) {
        String str = "a:1#b:2#c:3@x:8";
        String[] spl = new String[]{"@","#",":"};
        int x ='A'-'a';
        System.out.println(x);
    }
}
