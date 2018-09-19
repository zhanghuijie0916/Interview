package exam;


import java.util.Scanner;


public class XinLang1 {

    public static int LCS(String s1, String s2){
        int[][] arr = new int[s1.length() + 1][s2.length() + 1];
        for(int row = 0; row <= s1.length(); row++)
            arr[row][0] = 0;
        for(int col = 0; col <= s2.length(); col++)
            arr[0][col] = 0;

        for(int i = 1; i <= s1.length(); i++)
            for(int j = 1; j <= s2.length(); j++)
            {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    arr[i][j] = arr[i-1][j-1] + 1;
                else if(arr[i][j-1] > arr[i-1][j])
                    arr[i][j] = arr[i][j-1];
                else
                    arr[i][j] = arr[i-1][j];
            }
        return arr[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        /*System.out.println(s1);
        System.out.println(s2);*/
        int result = LCS(s1, s2);
        System.out.println(result);
    }
}
