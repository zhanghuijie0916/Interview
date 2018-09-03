package org.sunny;

import java.util.Scanner;

/**
 * 【最长的公共连续子串】给出两个字符串（可能包含空格）,找出其中最长的公共连续子串,输出其长度。 

 输入描述:输入为两行字符串（可能包含空格），长度均小于等于50.

 输出描述:输出为一个整数，表示最长公共连续子串的长度。


 */
public class MaxStringLength {
    public static int findLCS(String A, String B) {
        char[] s1 = A.toCharArray();
        char[] s2 = B.toCharArray();
        int max = 0;
        int[] dp = new int[s2.length+1];
        dp[0] = 0;
        for(int i = 0; i < s1.length; ++i){
            for(int j = dp.length-1; j >= 1; --j){
                if(s1[i] == s2[j-1])   dp[j] = dp[j-1] + 1;
                else   dp[j] = 0;
                if(dp[j]> max)  max = dp[j];
            }
        }
        return max;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int len = findLCS(s1, s2);
        System.out.println(len);

    }
}
