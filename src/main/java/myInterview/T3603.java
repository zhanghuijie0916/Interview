package myInterview;

import java.util.ArrayList;
import java.util.*;

public class T3603 {
    public static void main(String[] args) throws Exception {
        ArrayList<ArrayList<Integer>> allList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        //System.out.println(Integer.MAX_VALUE);
        long res = 0L;

        Scanner sc=new Scanner(System.in);
        int p = Integer.valueOf(sc.nextLine());
        String[] arr = sc.nextLine().split(" ");
        for (int i=0;i<p;i++){
            list.add(Integer.valueOf(arr[i]));
        }


        //得到全排列
//        System.out.println("-----------------全排列------------------");
        calQuanSort(allList,list,0);

        for (int i=0;i<allList.size();i++){
            ArrayList<Integer> templist = allList.get(i);
            for (int j=1;j<templist.size();j++){
                res = res+Math.abs(templist.get(j)-templist.get(j-1))% (long)(Math.pow(10,9)+7);
            }

//            res = res;
            /*System.out.println();
            allList.get(i).forEach(System.out::print);*/
        }
//        System.out.println("---------------------------------------");
        System.out.println(res);
    }

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



}
