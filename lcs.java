import java.util.Collection;
import java.util.Scanner;

public class lcs {
    static int lc(int l1, int l2, String x, String y) {
        String s = "";
        int p = 0;
        int check[][] = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 || j == 0)
                    check[i][j] = 0;
                else if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    check[i][j] = check[i - 1][j - 1] + 1;
                } else
                    check[i][j] = Math.max(check[i - 1][j], check[i][j - 1]);
            }
        }
        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[i].length; j++) {
                System.out.print(check[i][j]+" ");
            }
            System.out.println();
        }
        int i = l1;
        int j = l2;
        int index = check[l1][l2];
        char S1[] = x.toCharArray();
        char S2[] = y.toCharArray();
        char lcsAlgo[] = new char[index + 1];
        lcsAlgo[index] = '\0';
        while (i > 0 && j > 0) {
            if (S1[i - 1] == S2[j - 1]) {
                lcsAlgo[index - 1] = S1[i - 1];
                i--;
                j--;
                index--;
            }

            else if (check[i - 1][j] > check[i][j - 1])
                i--;
            else
                j--;
        }
        System.out.println(lcsAlgo);
        return check[l1][l2];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter first string :");
        String string1 = scn.nextLine();
        System.out.println("Enter second string :");
        String string2 = scn.nextLine();
        System.out.println(
                "the Longest Common Subsequence is " + lc(string1.length(), string2.length(), string1, string2));
        scn.close();
    }
}
