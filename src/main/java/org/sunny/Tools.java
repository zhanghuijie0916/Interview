package org.sunny;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools {

    public static void main(String[] strs){
        ArrayList<ArrayList<Integer>> allList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        //得到全排列
        System.out.println("-----------------全排列------------------");
        calQuanSort(allList,list,0);
        for (int i=0;i<allList.size();i++){
            System.out.println();
            allList.get(i).forEach(System.out::print);
        }
        System.out.println("---------------------------------------");

        //得到数组的子集
        System.out.println("-----------------数组子集------------------");
        ArrayList<ArrayList<Integer>> allsubsets = getSubsets(list, 0);
        for (ArrayList<Integer> set : allsubsets) {
            System.out.println(set);
        }
        System.out.println("-----------------------------------------");
    }

    /**
     * 得到arraylist的全排序
     * @param allList
     * @param list
     * @param n
     */
    public static void calQuanSort(ArrayList<ArrayList<Integer>> allList,ArrayList<Integer> list,int n){

        if (n==list.size()){
            allList.add(new ArrayList<>(list));
        }

        else {
            for (int i=n;i<list.size();i++){
                Collections.swap(list,i,n);
                calQuanSort(allList,list,n+1);
                Collections.swap(list,i,n);
            }
        }
    }

    /*
     * 参数arrayA:给定字符串的字符数组
     * 参数start:开始遍历字符与其后面各个字符将要进行交换的位置
     * 参数end:字符串数组的最后一位
     * 函数功能：输出字符串数字的各个字符全排列
     *
     * 主函数：
        String A = "abc";
        char[] arrayA = A.toCharArray();
        test.recursionArrange(arrayA,0,arrayA.length-1);
     */
    public static void recursionArrange(char[] arrayA,int start,int end){
        if(end <= 1)
            return;
        if(start == end){
            StringBuilder builder = new StringBuilder();
            for(int i = 0;i < arrayA.length;i++)
                builder.append(arrayA[i]);
                /*System.out.print(arrayA[i]);*/
            System.out.println();
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

    /**
     * 得到小于n的质数
     * @param n
     * @return
     */
    public static List<Integer> listPrime(int n) {
    /*
     * false为质数,true为合数
     */
        boolean[] primeList = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (!primeList[i]) {

                int j = i * i;

                if (j > n) // 所有合数都已被标记
                    break;
                if (i > 2) {
                /*
                 * 将所有能被此质数整除的奇数标记为合数
                 */
                    while (j <= n) {
                        primeList[j] = true;
                        j = j + i + i;
                    }
                } else {
                /*
                 * 将所有大于2的偶数标记为合数
                 */
                    while (j <= n) {
                        primeList[j] = true;
                        j = j + i;
                    }
                }
            }
        }
        List<Integer> listPrime = new LinkedList<Integer>();
        if( n > 1 )
            listPrime.add(2);
        for (int i = 3; i <= n; i += 2) {
            if (!primeList[i]) {
                listPrime.add(i);
            }
        }
        System.out.println(listPrime.size());
        return listPrime;
    }

    /**
     * 判断一个数是否是质数
     * @return
     */
    public static boolean isPrime(int a){
        boolean flag = true;
        if(a<2){
            return false;
        }else{
            for(int i=2;i<a;i++){
                if(a%i==0){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    /**
     *
     *得到一个数在斐波那切数列中的位置
     */
    public static void getFiboBetween(int n){
        int s1 = 0, s2 = 1;
        while(s2 <= n){
            int s3 = s1 + s2;
            s1 = s2;
            s2 = s3;
        }
        //s1、s2就是n两边的斐波那契数
        System.out.println((s2-n)>(n-s1)?n-s1:s2-n);
    }

    /**
     * 得到一个数组的所有子集
     *
     */
    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> allsubsets;
        if(set.size() == index){
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>()); //empty set
        }else{
            allsubsets = getSubsets(set, index+1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets =  new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> s: allsubsets){
                ArrayList<Integer> newSubset = new ArrayList<Integer>();
                newSubset.addAll(s);
                newSubset.add(item);
                moresubsets.add(newSubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

    /*
    模式匹配
    刚才我说了我要退款我要退款我要退款我都说了我要退款 => 刚才我说了我要退款我都说了我要退款
    阿里旺旺 => 阿里旺旺
    刚才我说了我要退款我都说了我要退款 => 刚才我说了我要退款我都说了我要退款
     */
    public static void regexMatch(String s){
        Pattern pattern = Pattern.compile("(\\D{2,})(\\1)+");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            String pstr = matcher.group(1);
            s = s.substring(0,start+pstr.length())+s.substring(end,s.length());
            System.out.println(s);
            matcher.reset(s);
        }

        System.out.println(s);
    }

    /**
     * 获取字符串的所有子串
     */
    public static void getAllSubString(String str){
        List<String> list = new ArrayList<>();

        for(int i = 0; i < str.length(); i++){
            for (int j = i+1; j<=str.length(); j++){
                list.add(str.substring(i,j));
            }
        }
    }

    /**
     * 判断是否是回文
     */
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

    /**
     * 考察字符串序列是否根据字典序排序
     */
    private static boolean isAbc(String[] words) {
        boolean result = true;
        for (int i = 1; i < words.length; i++) {
            if (words[i].compareTo(words[i - 1]) <= 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * 求两个数的最大公约数
     */
    public static int gcd(int m,int n){
        while (n!=0){
            int r = m%n;
            m = n;
            n = r;
        }
        return m;
    }

    /**
     * 求两个数的最小公倍数
     */
    public static int commonMultiple(int n, int m) {// 求两个数的最小公倍数
        // 两个数相乘等于这两个数的最大公约数和最小公倍数的积。
        return n * m / gcd(n, m);
    }

    /**
     * 求多个数的最小公倍数
     */
    public static int commonMultiple(int[] a) {// 求多个数的最小公倍数
        int value = a[0];
        for (int i = 1; i < a.length; i++) {
            value = commonMultiple(value, a[i]);
        }
        return value;
    }

    /**
     * 字符串的交集、差集、并集
     */
    public static void setCal(){
        Set<String> result = new HashSet<String>();
        Set<String> set1 = new HashSet<String>() {
            {
                add("王者荣耀");
                add("英雄联盟");
                add("穿越火线");
                add("地下城与勇士");
            }
        };
        Set<String> set2 = new HashSet<String>() {
            {
                add("王者荣耀");
                add("地下城与勇士");
                add("魔兽世界");
            }
        };
        result.clear();
        result.addAll(set1);
        result.retainAll(set2);
        System.out.println("交集：" + result);

        result.clear();
        result.addAll(set1);
        result.removeAll(set2);
        System.out.println("差集：" + result);

        result.clear();
        result.addAll(set1);
        result.addAll(set2);
        System.out.println("并集：" + result);
    }


}

