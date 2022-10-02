import java.util.Scanner;

public class RomToInt {
    public int romanToInt(String s) {
        int num = 0;
        char a[] = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 'I') {
                if ((i + 1) != a.length) {

                    if (a[i + 1] == 'X') {
                        num = num + 9;
                        i += 1;
                        continue;
                    }

                    else if (a[i + 1] == 'V') {
                        num = num + 4;
                        i += 1;
                        continue;
                    } else
                        num = num + 1;
                } else
                    num = num + 1;
            } else if (a[i] == 'X') {
                if ((i + 1) != a.length) {

                    if (a[i + 1] == 'L') {
                        num = num + 40;
                        i += 1;
                        continue;
                    }

                    else if (a[i + 1] == 'C') {
                        num = num + 90;
                        i += 1;
                        continue;
                    } else
                        num = num + 10;
                } else
                    num = num + 10;
            } else if (a[i] == 'C') {
                if ((i + 1) != a.length) {
                    if (a[i + 1] == 'D') {
                        num = num + 400;
                        i += 1;
                        continue;
                    }

                    else if (a[i + 1] == 'M') {
                        num = num + 900;
                        i += 1;
                        continue;
                    } else
                        num = num + 100;
                } else
                    num = num + 100;
            } else if (a[i] == 'V')
                num = num + 5;
            else if (a[i] == 'L')
                num = num + 50;
            else if (a[i] == 'D')
                num = num + 500;
            else if (a[i] == 'M')
                num = num + 1000;

        }
        return num;

    }

    public static void main(String[] args) {
        RomToInt a = new RomToInt();
        System.out.print("Enter Roman numeral :");
        System.out.println(a.romanToInt((new Scanner(System.in)).nextLine()));
    }
}
