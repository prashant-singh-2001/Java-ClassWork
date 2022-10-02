import java.util.Scanner;

public class lcs_recur {
    static int lcs(int i, int j, String s1, String s2) {
        if (i == 0 || j == 0)
            return 0;
        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            return 1 + lcs(i - 1, j - 1, s1, s2);
        else
            return Math.max(lcs(i - 1, j, s1, s2), lcs(i, j - 1, s1, s2));
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter first string :");
        String string1 = scn.nextLine();
        System.out.println("Enter second string :");
        String string2 = scn.nextLine();
        System.out.println(
                "the Longest Common Subsequence is " + lcs(string1.length(), string2.length(), string1, string2));
        scn.close();
        }
}
