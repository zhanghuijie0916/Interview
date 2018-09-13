package exam;

import java.util.*;


public class SouHu1 {
    public static void main(String args[]) {
        String str1 = "abwsawww";
        String str2 = "wbaabwsw";
        if (test(str1, str2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static boolean test(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        else {
            for (int i = 0; i < str1.length(); i++) {
                String ch = str1.charAt(i) + "";
                if (str2.contains(ch))
                    str2 = str2.replaceFirst(ch, "");
                else
                    return false;
            }
            return true;
        }
    }
}