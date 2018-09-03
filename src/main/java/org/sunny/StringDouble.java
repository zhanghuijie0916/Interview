package org.sunny;

/**
 * 如果一个字符串S是由两个字符串T连接而成,即S = T + T, 我们就称S叫做平方串,例如"","aabaab","xxxx"都是平方串.
 牛牛现在有一个字符串s,请你帮助牛牛从s中移除尽量少的字符,让剩下的字符串是一个平方串。换句话说,就是找出s的最长子序列并且这个子序列构成一个平方串。
 输入描述:
 输入一个字符串s,字符串长度length(1 ≤ length ≤ 50),字符串只包括小写字符。

 输出描述:
 输出一个正整数,即满足要求的平方串的长度。
 */

import java.util.*;
public class StringDouble {
    public static void main(String[]args){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        if(s.length()==1) System.out.println(0);
        else{
            int res=0,i,n=s.length();
            for(i=0;i+1<n;i++)
                res=Math.max(res,maxLen(s.substring(0,i+1),s.substring(i+1)));
            System.out.println(res);
        }
    }
    public static int maxLen(String a,String b){
        int len1=a.length(),len2=b.length(),i,j;
        int [][]dp=new int[len1+1][len2+1];
        for(i=1;i<=len1;i++)
            for(j=1;j<=len2;j++)
                dp[i][j]=(a.charAt(i-1)==b.charAt(j-1)
                        ?dp[i-1][j-1]+1:Math.max(dp[i-1][j],dp[i][j-1]));
        return dp[len1][len2]*2;
    }
}