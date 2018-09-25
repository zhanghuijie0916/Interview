package exam;

import java.util.LinkedList;
import java.util.Scanner;

class ZiJie1 {
    public static int maxLongUniqueString(String s) {
        int res = 0;//记录最长子串长度
        int ct = 0;//记录当前子串长度
        char[] arr = s.toCharArray();
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])) {
                list.add(arr[i]);
                ct = list.size();
                if (ct > res)
                    res = ct;
            } else//如果新增字符与原子串中字符有重复的，删除原子串中重复字符及在它之前的字符，与新增字符组成新的子串
            {
                list.add(arr[i]);
                int first = list.indexOf(arr[i]);

                for (int j = 0; j < first; j++)
                    list.remove();

                list.remove();
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int res = maxLongUniqueString(s);
        System.out.println(res);
    }


}
