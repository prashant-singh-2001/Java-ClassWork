import java.util.*;

class vowel
	{
		public static void main(String []a)
			{
				
				Scanner scn = new Scanner(System.in);
				System.out.print("Enter your name : ");
				String name = scn.nextLine().toString();
				char f_n=name.toCharArray()[0];
				if(f_n == 'A' || f_n == 'E' || f_n == 'I' || f_n == 'O' || f_n == 'U')			
					{
						System.out.println("Your name starts with a Vowel!");	
					}
				else
					{
						System.out.println("Your name starts with a Consonant!");
					}
				}
	}