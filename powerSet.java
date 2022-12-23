import java.util.Scanner;

/**
 * powerSet
 */
public class powerSet {
    static void printPowerSet(String[] set) {
        long pset = (long) Math.pow(2, set.length);
        System.out.print("Power Set is \n{");
        for (int i = 0; i < pset; i++) {
            System.out.print("{");
            for (int j = 0; j < set.length; j++) {
                if ((i & (1 << j)) > 0){
                    System.out.print(set[j] + " ");
                    
                }
                if (i == 0 && j==0 )
                    System.out.print(" ");
            }
            System.out.println("}");
        }
        System.out.println(" } \n");
    }
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String elements=null;
        String set[];
        System.out.println("Enter the set : ");
        elements=scn.nextLine();
        set=elements.split("[ ,]+");
        System.out.print("{");
        for (String string : set) {
            System.out.print(string+" ");
        }
        System.out.print("}\n");
        printPowerSet(set);
        scn.close();
    }
}
