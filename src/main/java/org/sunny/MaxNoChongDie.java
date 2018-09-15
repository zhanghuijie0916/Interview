package org.sunny;

import java.util.Scanner;

//最大子区间间隔

/**
 * 最大不重叠子区间
 * 输入
 * 3
 * 6 3
 * 1 3
 * 5 2
 * 输出：2
 */
class Point{
    int x;
    int y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class MaxNoChongDie {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());

        int pos, k, tmp, i, cur;
        Point[] seg = new Point[n];

        pos = 0;

        while (n-- >0) {
            String[] xy = scan.nextLine().split(" ");
            int x =  Integer.valueOf(xy[0]);
            int y =Integer.valueOf(xy[1]);
            Point p = null;
            if (x>y){
                p = new Point(y,x);
            }else {
                p = new Point(x,y);
            }

            seg[pos] = p;
            pos++;
        }
        //BubbleSort
        for (k = 1; k < pos; k++) {
            for (i = 0; i < pos - k; i++) {
                if (seg[i].y > seg[i + 1].y) {
                    //swap
                    tmp = seg[i + 1].y;
                    seg[i + 1].y = seg[i].y;
                    seg[i].y = tmp;
                    tmp = seg[i + 1].x;
                    seg[i + 1].x = seg[i].x;
                    seg[i].x = tmp;
                }
            }
        }
        //main process
        cur = seg[0].y;
        int cnt = 1;
        for (k = 1; k < pos; k++) {
            if (seg[k].x >= cur) {
                cur = seg[k].y;
                cnt++;
            }
        }
        System.out.println(cnt);

    }


}
