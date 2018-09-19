package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZiJie3 {
    public static int isUTF8(List<Byte> data){
        byte[] masks ={0x0,(byte) 0x80,(byte) 0xE0,(byte) 0xF0,(byte) 0xF8};
        byte[] bits ={0x0,(byte) 0x0,(byte) 0xC0,(byte) 0xE0,(byte) 0xF0};

        while (data.size()>0){
            int x;
            for (x=4;x>=0;x--){
                if ((data.get(0) & masks[x])== bits[x]){
                    break;
                }
            }

            if (x==0 || data.size()<x){
                return 0 ;
            }
            for (int y=1;y<x;y++){
                if ((data.get(y) & 0xC0) != 0x80){
                    return 0;
                }
            }

            data = data.subList(x,data.size());
        }

        return 1;

    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Byte> data = new ArrayList<>();
        for (int i=0;i<n;i++){
            data.add((byte)sc.nextInt());
        }

        int res = isUTF8(data);
        System.out.println(res);


    }
}