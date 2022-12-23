import java.util.Scanner;

public class Calculator {
    long powerInt(int num1,int num2)
    {
        return (long)Math.pow(num1, num2);
    }
    double powerDouble(double num1,int num2)
    {
        return Math.pow(num1, num2);
    }

    public static void main(String[] args) {
        int num1,num2,num3;
        double num;
        Scanner sc=new Scanner(System.in);
        Calculator cal=new Calculator();
        System.out.println("Enter the base :");
        num1=sc.nextInt();
        System.out.println("Enter the power :");
        num2=sc.nextInt();
        System.out.println(cal.powerInt(num1, num2)+"\n\n");

        System.out.println("Enter the base (can be floating point):");
        num=sc.nextDouble();
        System.out.println("Enter the power :");
        num3=sc.nextInt();
        System.out.println(cal.powerDouble(num, num3));
        sc.close();
    }
}
