package ClosedLabBook;

import java.util.Scanner;

public class TwoDimensionalArrayPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the array size row and coloum");
		int count = 1,row = sc.nextInt();
		for(int i=0;i<row;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(count++ + " ");
			}
			System.out.println();
		}

	}

}
