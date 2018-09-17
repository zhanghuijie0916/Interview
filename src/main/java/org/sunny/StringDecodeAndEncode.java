package org.sunny;


import java.util.*;

/**
 * 字符串编码：
 * aaabbbsdsa
 答案：a4b3d1s2
 */
public class StringDecodeAndEncode {
    /*
    字符串编码
     */
    public static String stringEncode(String s){
        StringBuilder builder = new StringBuilder();
        char cur = s.charAt(0);
        int count = 1;
        for (int i=1;i<s.length();i++){
            if (cur==s.charAt(i)){
                count++;
            } else {
                builder.append(cur);
                builder.append(count);
                cur = s.charAt(i);
                count = 1;
            }
        }
        builder.append(cur);
        builder.append(count);
        System.out.println(builder.toString());
        return builder.toString();
    }

    /**
     * 字符串解码
     */
    public static String stringDecode(String s){
        char[] chars = s.toCharArray();

        char cur = chars[0];
        StringBuilder result = new StringBuilder();
        StringBuilder tempbuild = new StringBuilder();
        for (int i = 1;i<chars.length;i++){
            int count = chars[i]-'0';
            if (count>0 && count<9){
                tempbuild.append(count);
            }
            else {
                for (int j=0;j<Integer.valueOf(tempbuild.toString());j++){
                    result.append(cur);
                }
                tempbuild = new StringBuilder();
                cur = chars[i];
            }
        }

        //最后字符的注入
        for (int j=0;j<Integer.valueOf(tempbuild.toString());j++){
            result.append(cur);
        }

        System.out.println(result.toString());
        return result.toString();
    }


    public static void main(String[] args){
        /*Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();*/
        String s = "aaaaaaaaaaaaaaaabbcbaaa";
        String decodeStr = stringEncode(s);
        String encodeStr = stringDecode(decodeStr);
        System.out.println(s.equals(encodeStr));
    }
}
