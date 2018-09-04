package org.sunny;

import java.util.*;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/a5190a7c3ec045ce9273beebdfe029ee
 来源：牛客网

 一个袋子里面有n个球，每个球上面都有一个号码(拥有相同号码的球是无区别的)。如果一个袋子是幸运的当且仅当所有球的号码的和大于所有球的号码的积。
 例如：如果袋子里面的球的号码是{1, 1, 2, 3}，这个袋子就是幸运的，因为1 + 1 + 2 + 3 > 1 * 1 * 2 * 3
 你可以适当从袋子里移除一些球(可以移除0个,但是别移除完)，要使移除后的袋子是幸运的。现在让你编程计算一下你可以获得的多少种不同的幸运的袋子。
 输入描述:
 第一行输入一个正整数n(n ≤ 1000)
 第二行为n个数正整数xi(xi ≤ 1000)


 输出描述:
 输出可以产生的幸运的袋子数

 */

/**
 *
 题目可以转化成求符合条件的集合真子集个数。每次从全集中选择若干元素（小球）组成子集（袋子）。
 集合子集个数为2^n个，使用dfs必然超时。且此题有重复元素，那么就搜索剪枝。
 对于任意两个正整数a,b如果满足 a+b>a*b，则必有一个数为1.
 因此，将球按标号升序排序。每次从小到大选择，当选择到a1,a2,...,ak-1时满足给定条件，
 而再增加选择ak时不满足条件（ak必然大于等于max(a1,a2,...,ak-1)），继续向后选择更大的数，
 必然无法满足！因此，可以进行剪枝。如果有多个1，即当k=1时，sum(1)>pi(1)不满足，
 但下一个元素仍为1，则可以满足1+1>1*1，所以要判断当前ak是否等于1.
 */
public class SumBiggerThanMulit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i=0; i<n; i++)
                nums[i] = scanner.nextInt();

            Arrays.sort(nums);
            System.out.println(find(nums, 0, 0, 1));
        }
    }

    private static int find(int[] nums, int index, long sum, long multi) {
        int count = 0;
        for(int i=index; i<nums.length; i++) {
            sum += nums[i];
            multi *= nums[i];
            if(sum > multi)
                count += 1 + find(nums, i+1, sum, multi);
            else if(nums[i] == 1)
                count += find(nums, i+1, sum, multi);
            else
                break;
            sum -= nums[i];
            multi /= nums[i];
            //去重复
            while (i<nums.length-1 && nums[i]==nums[i+1])
                i++;
        }
        return count;
    }
}