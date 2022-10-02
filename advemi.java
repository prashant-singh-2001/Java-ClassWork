import java.util.Scanner;

public class advemi {
    static double principle;
    static double rate;
    static double time;
    static double emi;
    static double simpleInterest;
    static int flag;

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the Principle amount : ");
        principle = scn.nextDouble();
        System.out.println("Enter the Rate of interest : ");
        rate = scn.nextDouble();
        System.out.println("Enter the Years of Investment : ");
        time = scn.nextDouble();
        simpleInterest = (principle * time * rate) / 100.0;
        System.out.println("Your total simple interest is : " + simpleInterest);
        System.out.println(
                "Choose your Withdraw time period : \n\nPress 1 for Monthly \nPress 2 for Quartley \nPress 3 for Half Yearly \nPress 4 for Yearly");
        flag = scn.nextInt();
        switch (flag) {
            case 1: {
                emi = (simpleInterest) / (time * 12);
                System.out.println("Your monthly income is : " + emi);
                break;
            }
            case 2: {
                emi = (simpleInterest) / (time * 4);
                System.out.println("Your quarterly income is : " + emi);
                break;
            }
            case 3: {
                emi = (simpleInterest) / (time * 2);
                System.out.println("Your half-yearly income is : " + emi);
                break;
            }
            case 4: {
                emi = (simpleInterest) / (time);
                System.out.println("Your Yearly income is : " + emi);
                break;
            }
            default: {
                System.out.println("Enter valid choice!");
                break;
            }
        }
        scn.close();
    }
    
}
