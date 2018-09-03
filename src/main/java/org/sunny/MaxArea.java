package org.sunny;

/**
 *链接：https://www.nowcoder.com/questionTerminal/13ba51c3fec74b58bbc8fa8c3eedf877
 来源：牛客网

 有一个直方图，用一个整数数组表示，其中每列的宽度为1，求所给直方图包含的最大矩形面积。比如，对于直方图[2,7,9,4],它所包含的最大矩形的面积为14(即[7,9]包涵的7x2的矩形)。
 给定一个直方图A及它的总宽度n，请返回最大矩形面积。保证直方图宽度小于等于500。保证结果在int范围内。

 测试样例：
 [2,7,9,4,1],5
 返回：14

 思路：根据动态规划的思路，创建一个dp表，dp[i][j]的意思是i到j之间的最大矩形面积。
 dp[i][j]的计算有三种可能：
 1.取最小面积乘以总个数
 2.取(dp[i][j-1]
 3.取dp[i+1][j]
 总结来说dp的值为：
 dp[i][i+k]=Math.max(dp[i][i+k-1], dp[i+1][i + k]);
 dp[i][i+k]=Math.max(min*(k+1),dp[i][i+k]);

 */

import java.util.*;
public class MaxArea {
    /*
     * 思路：根据动态规划的思路，创建一个dp表，dp[i][j]的意思是i到j之间的最大矩形面积。
    dp[i][j]的计算有三种可能：
    1.取最小面积乘以总个数
    2.取(dp[i][j-1]
    3.取dp[i+1][j]
    总结来说dp的值为：
    dp[i][i+k]=Math.max(dp[i][i+k-1], dp[i+1][i + k]);
    dp[i][i+k]=Math.max(min*(k+1),dp[i][i+k]);
     * */
    public int countArea(int[] A, int n) {
        // write code here
        int [][] dp=new int[n][n];
        for(int i=0;i<n;i++)
        {
            dp[i][i]=A[i];
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j+i<n;j++)
            {
                int min=A[j];
                for(int k=j+1;k<=i+j;k++)
                {
                    min=Math.min(min, A[k]);
                }
                dp[j][j+i]=Math.max(dp[j][j+i-1], dp[j+1][j+i]);
                dp[j][j+i]=Math.max(min*(i+1), dp[j][j+i]);
            }
        }
        return dp[0][n-1];
    }
}

