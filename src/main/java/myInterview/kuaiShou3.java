package myInterview;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class kuaiShou3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int kinds = scan.nextInt();
        int M = scan.nextInt();
        int[] array = new int[kinds];
        for (int i=0;i<kinds;i++){
            array[i] = scan.nextInt();
        }

        List<Integer> list = new ArrayList<>();
        int sum = 0; //TEMP
        int pcount = 0;
        int res = 0;
        List<Integer> pindex = new ArrayList<>();
        for (int i=0;i<kinds;i++){
            if (array[i]>0){
                sum += array[i];
            }else {
                if (sum !=0){
                    res += sum;
                    list.add(sum);
                    pindex.add(list.size()-1);
                    pcount++;
                }
                list.add(array[i]);
                sum = 0;
            }
        }
        if (sum !=0){
            res += sum;
            list.add(sum);
            pcount++;
            pindex.add(list.size()-1);
        }

        //System.out.println(pcount);
//        list.forEach(x->System.out.print(x+" "));
        //System.out.println();
        //pindex.forEach(x->System.out.print(x+" "));
        if (pcount<M){
            System.out.println(res);
        }
        //需要合并
        else {

            List<Integer> a = list;
            boolean flag = true;
            while (flag){
                flag = false;
                for (int i=0;i<pindex.size()-1;i++){
                    int left = pindex.get(i);
                    int right = pindex.get(i+1);
                    int temp = 0;
                    for (int j=left;j<=right;j++){
                        temp += list.get(j);
                    }
                    if (temp>list.get(left) & temp>list.get(right)){
                        a = a.subList(0,left);
                        a.add(temp);
                        a.addAll(list.subList(right+1,list.size()));
                        list = a;
                        flag = true;
                        for (int t=i+2;t<pindex.size()-1;t++){
                            pindex.set(t,pindex.get(t)-(right-left));
                        }
                    }
                    //list.forEach(x->System.out.print(x+" "));
                }
            }

            int[] w = new int[a.size()];
            for (int i=0;i<a.size();i++){
                w[i] = a.size();
            }

            Arrays.sort(w);
            int q = 0;
            for (int i=0;i<M;i++){
                q+=w[i];
            }
            System.out.println(res);


        }

    }
}
