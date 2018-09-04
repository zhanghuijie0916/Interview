package org.sunny;

import java.util.*;

/**
 * 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
 输入描述:
 每个测试输入包含2个整数,n和m
 输出描述:
 按每个组合的字典序排列输出,每行输出一种组合
 */
public class AddSum2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList aList = new ArrayList<Integer>();
            for(int i=1;i<=n;i++){
                aList.add(i);
                count(m, i, i,n,aList);
                aList.remove(aList.size()-1);
            }
        }
    }
    public static void count(int m, int sum, int currentVal, int n, ArrayList aList){
        if(sum>m)return;
        if(sum==m){
            StringBuilder sb = new StringBuilder();
            Iterator it = aList.iterator();
            while(it.hasNext()){
                sb.append(it.next() + " ");
            }
            System.out.println(sb.toString().trim());
        }else{
            for(int i=currentVal+1;i<=n;i++){
                aList.add(i);
                count(m, sum+i, i, n,aList);
                aList.remove(aList.size()-1);
            }
        }
    }
}
