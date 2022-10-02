import java.util.Scanner;

public class lcs_recur_2 {
    static int lcs(int i, int j, String s1, String s2, int check[][]) {
        // Checking if string are empty or not
        if (i == 0 || j == 0)
            return 0;
        // Checking if already checked
        if (check[i][j] != -1)
            return check[i][j];

        // checking if the last character is same or not
        if (s1.charAt(i - 1) == s2.charAt(j - 1))
            return check[i][j] = 1 + lcs(i - 1, j - 1, s1, s2, check);
        else
            return check[i][j] = Math.max(lcs(i - 1, j, s1, s2, check), lcs(i, j - 1, s1, s2, check));
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter first string :");
        String string1 = scn.nextLine();
        System.out.println("Enter second string :");
        String string2 = scn.nextLine();
        int check[][] = new int[string1.length() + 1][string2.length() + 1];
        for (int i = 1; i <= string1.length(); i++) {
            for (int j = 1; j <= string2.length(); j++) {
                check[i][j] = -1;
            }
        }
        System.out.println(
                "the Longest Common Subsequence is "
                        + lcs(string1.length(), string2.length(), string1, string2, check));
        scn.close();
    }
}
