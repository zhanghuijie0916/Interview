package myInterview;

import java.util.Scanner;

public class XiaoYing2 {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String[] temp = scan.nextLine().split(" ");
        int key = Integer.valueOf(temp[1]);  //匹配关键字
        String[] arrs = temp[0].split(",");
        int res = 0;  //结果
        int i=0;
        for (;i<arrs.length-1;i++){
            int cur = Integer.valueOf(arrs[i]);
            int next = Integer.valueOf(arrs[i+1]);
            if (cur>=key && next>=key){
                break;
            }
            if (cur<key && next>=key){
                res = cur;
            }
        }

        //System.out.println(i);
        if (i==arrs.length-1){
            if (Integer.valueOf(arrs[i]) < key){
                res = Integer.valueOf(arrs[i]);
            }else {
                res = Integer.valueOf(arrs[i-1]);
            }

        }
        System.out.println(res);
    }
}
