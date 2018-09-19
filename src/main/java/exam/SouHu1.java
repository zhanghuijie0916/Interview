package exam;

import java.util.*;


public class SouHu1 {
    public static boolean isHuiWen(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String[] arr = a.split(" ");
        if (arr[0].equals(arr[1]) & arr[0].length()==1){
            System.out.println("0");
        }
        else if (arr[0].equals(arr[1])){
            if (isHuiWen(arr[0])){
                System.out.println("1");
            }else {
                System.out.println("0");
            }
        }else {
            if (test(arr[0], arr[1])){

                System.out.println("1");
            }

            else
                System.out.println("0");
        }

    }

    public static boolean test(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        else {
            for (int i = 0; i < str1.length(); i++) {
                String ch = str1.charAt(i) + "";
                if (str2.contains(ch))
                    str2 = str2.replaceFirst(ch, "");
                else
                    return false;
            }
            return true;
        }
    }
}