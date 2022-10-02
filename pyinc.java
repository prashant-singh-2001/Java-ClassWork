import java.util.Scanner;

public class pyinc {
    static void printString(String s,int n)
        {
            for(int space = 1; space < n ; ++space) {
                System.out.print(s);
              }
        }
    public static void main(String[] args) {
        int rows=0;
        System.out.println("Enter nummber of rows :");
        rows=(new Scanner(System.in)).nextInt();
        for (int i = 1; i <= rows; i++) {
            // white spaces in the front of the numbers
            int numberOfWhiteSpaces = (rows-i+1);
    
            //print leading white spaces
            printString(" ", numberOfWhiteSpaces);
            int x=1;
            int flag=0;
            //print numbers
            while(x!=0)
            {

                if(flag==0){
                    
                    if(x<i)
                    {
                        System.out.print(x+" ");
                        x++;
                    }
                    else
                    flag++;
                }
                else
                {
                    System.out.print(x+" ");
                    x--;
                }
            }
    
            //move to next line
            System.out.println("");
    }
}
}
