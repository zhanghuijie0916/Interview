package org.sunny;

import java.util.Scanner;

/*需求:对于一个只有0和1的二维矩阵,上下或者左右相邻元素都为1则为一块(斜着不算),求一共有多少取值为1的连续块.如下图:
 *
 *   0 1 0 1 1 0
 *   1 1 0 0 1 1
 *   0 0 1 0 0 0
 *   1 1 0 0 0 0
 *
 * 上图中有4块
 */

public class FindGroup {
    // 共享成员变量,矩阵
    static int[][] array = null;
    // 主函数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        array = new int[M][M];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int k = scanner.nextInt();
                array[i][j] = k;
                //System.out.print(" " + array[i][j]);
            }
            //System.out.println();
        }

        creatarray();
    }

    // 生成指定的随机矩阵,计算块数
    private static void creatarray() {
        // 设定矩阵的高和宽
        int h = array.length;


        // 计数
        int count = 0;
        // 遍历矩阵找1,块的定位
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h; j++) {
                // 当找到1时,开始处理其所在的块
                if (array[i][j] == 1) {
                    continueBlock(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    // 判断连续块,递归
    private static void continueBlock(int i, int j) {
        // 修改(i,j)坐标对应的数组元素的值(避免递归时反复判断相邻元素)
        array[i][j] = 4;
        // 分别判断上下左右
        if (i < array.length - 1 && array[i + 1][j] == 1) {
            continueBlock(i + 1, j);
        }
        if (i > 0 && array[i - 1][j] == 1) {
            continueBlock(i - 1, j);
        }
        if (j < array[i].length - 1 && array[i][j + 1] == 1) {
            continueBlock(i, j + 1);
        }
        if (j > 0 && array[i][j - 1] == 1) {
            continueBlock(i, j - 1);
        }
    }

}
