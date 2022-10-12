import java.util.Scanner;

public class Control_Stats {
    static void last_digit(int n, int m) {
        System.out.println(n % 10 == m % 10 ? true : false);
    }

    static void odd_even(int n) {
        System.out.println(n % 2 == 0 ? n + "is even." : n + "is odd.");
    }

    static void alpha(char a, char b) {
        System.out.println(a < b ? a + ", " + b : b + ", " + a);
    }

    static void chec(char a) {
        if (a >= 'a' && a <= 'Z')
            System.out.println("Alphabet");
        else if (a >= '0' && a <= '9')
            System.out.println("Digit");
        else
            System.out.println("Special Character!");
    }

    static void change(char a) {
        System.out.println(a >= 'A' ? a + "->" + (char) (a - 32) : a + "->" + (char) (a + 32));
    }

    static void color(char a) {
        a=Character.toUpperCase(a);
        switch (a) {
            case 'R':
                System.out.println("Red");
                break;

            case 'B':
                System.out.println("Blue");
                break;

            case 'G':
                System.out.println("Green");
                break;

            case 'O':
                System.out.println("Orange");
                break;

            case 'Y':
                System.out.println("Yellow");
                break;

            case 'W':
                System.out.println("White");
                break;

            default:
                System.out.println("Invalid code!");
        }
    }

    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers for same last Digit : ");
        n = sc.nextInt();
        m = sc.nextInt();
        last_digit(n, m);
        n = 0;
        m = 0;
        System.out.println("--------------------------------------");

        System.out.println("Enter number for odd even : ");
        n = sc.nextInt();
        odd_even(n);
        n = 0;
        System.out.println("--------------------------------------");

        if (args.length != 0)
            for (String string : args) {
                System.out.print(string + ", ");
            }
        else
            System.out.println("No Values");
        System.out.println("\n--------------------------------------");

        char a, b;
        System.out.println("Enter the characters : (it will only scan 1st character of each line!)");
        sc.nextLine();
        a = sc.nextLine().charAt(0);
        System.out.println();
        b = sc.nextLine().charAt(0);
        alpha(a, b);
        a = Character.MIN_VALUE;
        b = Character.MIN_VALUE;
        System.out.println("--------------------------------------");

        System.out.println("Enter the charcter for checking : ");
        a = sc.nextLine().charAt(0);
        chec(a);
        System.out.println("--------------------------------------");

        System.out.println("Enter the charcter to change : ");
        a = sc.nextLine().charAt(0);
        change(a);
        System.out.println("--------------------------------------");

        System.out.println("Enter the charcter to code : ");
        a = sc.nextLine().charAt(0);
        color(a);
        System.out.println("--------------------------------------");
    }
}
