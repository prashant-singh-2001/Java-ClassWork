import java.util.*;

public class powerBySet {
    static int[] reverse(int[] m, int a, int b) {
        int num = (b - a + 1) / 2;
        for (int i = 0; i < num; i++) {
            int x = m[a + i];
            m[a + i] = m[b - i];
            m[b - i] = x;
        }
        return m;
    }

    static boolean previous(int[] arr1) {
        int n = arr1.length - 1; // find last element
        int i = n;
        while (i > 0 && arr1[i - 1] <= arr1[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }
        int j = i - 1;
        while (j + 1 <= n && arr1[j + 1] < arr1[i - 1]) {
            j++;
        }
        int temp = arr1[i - 1];
        arr1[i - 1] = arr1[j];
        arr1[j] = temp;
        arr1 = reverse(arr1, i, arr1.length - 1);
        return true;
    }

    static void printPowerSet(String [] set, int n)
  {
 
    int[] array = new int[n];
      
    for (int i = 0; i < n; i++) {
      array[i] = 1;
 
    
      int[] array1 = new int[n];
      for (int index = 0; index < n; index++) {
        array1[index] = array[index];
      }
  
      do {
        for (int j = 0; j < n; j++) {
          if (array1[j] != 0) {
          
            System.out.print(set[j]+ " ");
          }
        }
        System.out.print(" \n ");
 
      } while (previous(array1));
    }
  }

    public static void main(String[] args)

    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter values : ");
        String s = scan.nextLine();
        String s_array[] = s.split("[ ,]+");
        System.out.println("\n { ");
        System.out.println(" { } ");
        printPowerSet(s_array, s_array.length);
        System.out.println("}");
    }

}
