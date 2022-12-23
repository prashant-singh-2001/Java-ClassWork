import java.util.Scanner;

public class frames {
    public static void main(String[] args) {
        int a = 0;
        Scanner scn = new Scanner(System.in);
        char userIn;
        for (int i = 1; i <= 64; i *= 2) {
            System.out.println("--------------------------------------");
            for (int k = 1; k <= 100; k++) {
                if ((k | i) == k)
                    System.out.print(k + " ");
            }
            System.out.println("\n--------------------------------------");
            System.out.println("Is your number in the list?");
            userIn = scn.nextLine().charAt(0);
            if (Character.toLowerCase(userIn) == 'y')
                a += i;

        }
        System.out.println("Your number is : " + a);
        scn.close();
    }
}
