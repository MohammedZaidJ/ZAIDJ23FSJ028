package OpenLabBook;

import java.util.Scanner;

public class OddOrEven {
	public static void main(String args[])
	{
	Scanner input = new Scanner(System.in);
	int num;
	System.out.println("Enter an Integer number:");
	num = input.nextInt();
	if ( num % 2 == 0 )
	System.out.println("Entered number is even");
	else
	System.out.println("Entered number is odd");
	}
	
}
