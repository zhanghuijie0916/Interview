package exam;



/**
 * @author Allen
 * @version 创建时间：2017年9月23日 下午7:00:47
 * 类说明：
 * 面试题14：剪绳子
 * 题目：给你一根长度为n的绳子，请把绳子剪成m段(m和n都是整数，n>1并且m>1)每段绳子的长度记为k[0],k[1],...,k[m].
 * 请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.
 */
public class zijie5 {
    public static void main(String[] args) {
        System.out.println(maxCutting(5));
    }
    public static int maxCutting(int length){
        if(length<2)
            return 0;
        if(length==2)
            return 1;
        if(length==3)
            return 2;
        //子问题的最优解存储在f数组中，数组中的第i个元素表示把长度为
        ///i的绳子剪成若干段后各段长度乘积的最大值。
        int[] f = new int[length+1];
        //这些情况下，不剪的时候长度比剪的时候长，所以作为初始条件
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        int result = 0;
        for(int i = 4;i<=length;i++){
            int max = 0;
            for(int j = 1;j<=i/2;j++){
                int num = f[j]*f[i-j];
                if(max<num)
                    max = num;
            }
            f[i] = max;
        }
        result = f[length];
        return result;
    }
}