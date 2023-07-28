package ClosedLabBook;

import java.util.Scanner;

public class LargestElementInEachRow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the size of Array\n");
		int n = sc.nextInt();
		System.out.print("Enter the array values\n");
		int[][] arr=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		System.out.println("Largest the Element in row of Array");
		for(int i=0;i<n;i++) {
			int larg=0;
			for(int j=0;j<n;j++) {
				if(arr[i][j]>larg) {
					larg=arr[i][j];
				}
			}
			System.out.println(larg);
		}
		


	}

}
