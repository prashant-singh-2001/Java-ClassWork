import java.util.Scanner;

public class lcs_new {
    static String lcs(String s1,String s2)
    {
        StringBuilder s=new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i)==s2.charAt(j))
                {
                    s.append(s2.charAt(j));
                    s2=s2.substring(0, j)+s2.substring(j+1, s2.length());
                    break;
                }
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter string 1 :");
        String s1=scn.nextLine();
        System.out.println("Enter string 1 :");
        String s2=scn.nextLine();
        String s=lcs(s1, s2);
        System.out.println(s);
        scn.close();
    }
}
