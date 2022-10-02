import java.util.Scanner;

public class Ackermann {
    int ack(int m, int n) {
        if (m < 0 || n < 0)
            return -1;
        if (m == 0)
            return n + 1;
        else if (n == 0)
            return ack(m - 1, 1);
        else
            return ack(m - 1, ack(m, n - 1));
    }

    public static void main(String[] args) {
        Ackermann ac = new Ackermann();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first number for Ackermann's Function: ");
        int m = sc.nextInt();
        System.out.println("Enter second number for Ackermann's Function: ");
        int n = sc.nextInt();
        int res = ac.ack(m, n);
        System.out.println(res < 0 ? "Entered values are invalid!" : res);
    }
}
