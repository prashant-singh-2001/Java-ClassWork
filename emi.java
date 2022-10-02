import java.util.Scanner;

/**
 * emi
 */
public class emi {

    public static void main(String[] args) {
        double principle;
        double rate;
        double time;
        double emi;
        double simpleInterest;
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter the Principle amount : ");
        principle=scn.nextDouble();
        System.out.println("Enter the Rate of interest : ");
        rate=scn.nextDouble();
        System.out.println("Enter the Years of Loan : ");
        time=scn.nextDouble();
        scn.close();
        simpleInterest=(principle*time*rate)/100.0;
        emi=(principle+simpleInterest)/(time*12);
        System.out.println("Your total simple interest is : " + simpleInterest);
        System.out.println("Your monthly emi is : " + emi);
        
    }
}
