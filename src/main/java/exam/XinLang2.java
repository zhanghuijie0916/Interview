package exam;

import java.util.Scanner;


public class XinLang2 {

    public static  String comp(String str){
        StringBuilder buf = new StringBuilder();
        int count = 1;
        char ch = str.charAt(0);
        for(int i = 1; i <= str.length();i++){
            char c = i==str.length() ? '\t':str.charAt(i);
            if(c==ch){
                count++;
            }else{
                buf.append(ch).append(count);
                count=1;
                ch = c;
            }

        }
        return buf.toString();
    }

    public static  String inverse(String str){
        StringBuilder buf = new StringBuilder();
        char[] ch = str.toCharArray();
        for(int i = 0; i < ch.length;i = i+2){
            int n = (int)ch[i+1]-'0';
            for(int j = 0; j < n; j++) {
                buf.append(ch[i]);
            }

        }
        return buf.toString();
    }




    public static void main(String[] args) {
        String str = "aaaabbbbccedddddaaaa";
        String str1 = "a4b4c2e1d5a4";

//压缩
        System.out.println(comp(str));
        System.out.println(str);
        System.out.println(inverse(str1));




    }


}
