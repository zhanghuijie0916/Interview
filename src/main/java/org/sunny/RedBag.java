package org.sunny;

/**
 * 题目： 圆桌上放了一圈红包形成环形，每个红包金额不同，围绕圆桌走一圈选择若干红包，
 * 规则是不能拿相邻的红包，请问拿到红包最多的总金额是多少？

 输入： 红包个数N   N行数组表示N个红包
 输出： 最多的总金额

 样例输入：
 2
 1，2
 1，3，4

 样例输出：
 2
 4
 */
import java.util.Scanner;

/**
 * 将问题理解成最优解问题：如果取第j个红包时，获得的是当前最多红包金额（最优解），
 * 那么func(j)的最优解可以分解成第j个红包前面的j-2个（隔1个取）和j-3个（隔2个取）
 * 得最优解的最大值加上arr[j]。用式子表达为：
 func(j) = max( func(j-2) , fun(j-3) ) + arr[i];
 */
public class RedBag {

    private static int func(int[] arr, int lo, int hi){
        if(hi<lo)
            return 0;
        return Math.max(func(arr, lo, hi-2),func(arr, lo, hi-3))+arr[hi];
    }

    public static int redBag(int[] arr){
        if(arr.length == 1) return arr[0];  //红包个数为1
        return Math.max(func(arr, 0, arr.length - 2), func(arr, 1, arr.length - 1));
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();  //表示的是n行红包
            for(int i = 0; i < n; i++){
                String s = in.next();
                String[] ss = s.split(",");
                int[] arr = new int[ss.length];   //每一行红包的红包个数
                for(int j = 0; j < ss.length; j++)
                    arr[j] = Integer.parseInt(ss[j]);
                System.out.println(redBag(arr));
            }
        }
    }
}
