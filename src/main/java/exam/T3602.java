package exam;

import java.util.Scanner;



public class T3602 {


    public static String transform(long num,long n){

        //参数num为输入的十进制数，参数n为要转换的进制
        long array[]=new long[10000];
        int count=0;
        int location=0;
        while(num!=0){//当输入的数不为0时循环执行求余和赋值
            long remainder=num%n;
            num=num/n;
            array[location]=remainder;//将结果加入到数组中去
            location++;
            count++;
        }
        String res = show(array,location-1,count,n);
        return res;
    }
    private static String show(long[] arr,int n,long count,long k){
        StringBuilder builder = new StringBuilder();
        for(int i=n;i>=0;i--){
            if(arr[i]<0) {
                for(int j=0;j<count-1;j++) {
                    arr[j]=Math.abs(arr[j]);
                }
            }
            if(arr[i]>9||arr[i]<-9){
                builder.append((char)(arr[i]+55));
                //System.out.print((char)(arr[i]+55));
            }
            else
                builder.append(arr[i]);
               // System.out.print(arr[i]+"");
        }

        return builder.toString();

    }

    public static void main(String[] args)

    {

        // 测试用例
        Scanner sc=new Scanner(System.in);
        int p = Integer.valueOf(sc.nextLine());
        for (int i=0;i<p;i++){
            String[] arr = sc.nextLine().split(" ");
            int k = Integer.valueOf(arr[0]);
            String q = (k-1)+"";
            long low = Integer.valueOf(arr[1]);
            long high = Integer.valueOf(arr[2]);
            long maxVal = 0;
            long maxLen = 0;


            //System.out.println(arr[0].charAt(0));
            for (long j=low;j<high;j++){
                String s = transform(j, k);

                char[] res = s.toCharArray();
                long tempc = 0;
                for (char a :res){
                    if (a==q.charAt(0)){
                        tempc++;
                    }
                }
                if (tempc>maxLen){
                    maxLen = tempc;
                    maxVal = j;
                }

                //System.out.println(j+":"+s+":"+tempc);
            }
            System.out.println(maxVal);
        }

        /*Scanner sc=new Scanner(System.in);

        String[] str=sc.nextLine().split(" ");

        int[] a=new int[str.length];

        for(int i=0;i<str.length;i++) {

            a[i]=Integer.parseInt(str[i]);

        }*/

        /*String s = t.transform(100, 8);
        System.out.println("-----");
        System.out.println(s);
*/


    }

}