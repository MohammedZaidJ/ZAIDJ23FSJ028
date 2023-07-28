package ClosedLabBook;

import java.util.Scanner;

public class ReverseTheElementsOfEachRow {

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
		System.out.println("Before Reverse the Element of Array");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int i=0;i<n;i++) {
			for(int revRow=0;revRow<n/2;revRow++) {
				int temp=arr[i][revRow];
				arr[i][revRow]=arr[i][n-revRow-1];
				arr[i][n-revRow-1]=temp;
			}
		}
		System.out.println("Before Reverse the Element of Array");
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		

	}

}
