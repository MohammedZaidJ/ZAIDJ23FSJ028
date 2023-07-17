package OpenLabBook;

import java.util.Scanner;

public class Pyramid {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for(int i=1;i<=5;i++){
			for(int j=1;j<=i;j++){
				System.out.print("* ");
			}
			System.out.println();//new line
		}
	
		
//		public class PyramidExampleReverse {
		int term=6;
		for(int i=1;i<=term;i++){
			for(int j=term;j>=i;j--){
				System.out.print("* ");
			}
			System.out.println();//new line
		}
		
		
//		Floyd Triangle
		
		int rows, number = 1, counter, j;
		System.out.println("Enter the number of rows for floyd's triangle:");
		rows = input.nextInt();
		System.out.println("Floyd's triangle");
		System.out.println("****************");
		for ( counter = 1 ; counter <= rows ; counter++ ){
			for ( j = 1 ; j <= counter ; j++ ){
				System.out.print(number+" ");
				number++;
			}
			System.out.println();
		}
	}
		
}
