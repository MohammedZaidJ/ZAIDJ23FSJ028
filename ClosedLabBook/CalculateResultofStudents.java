package ClosedLabBook;

import java.util.Scanner;

public class CalculateResultofStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the No. Students");
		int n=sc.nextInt();
		String[] name = new String[n];
		int[][] marks = new int[n][3];
		for(int i=0;i<n;i++) {
			System.out.print("Name Maths  Physics  Chemistry\n");
			name[i] = sc.next();
			for(int j=0;j<3;j++) {
				marks[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("RollNo  Name   Maths  Physics  Chemistry   total");
		for(int i=0;i<n;i++) {
			System.out.print((i+1)+". "+name[i]+"    ");
			int sum=0;
			for(int j=0;j<3;j++) {
				System.out.print(marks[i][j]+"  ");
				sum+=marks[i][j];
			}
			System.out.print(sum+"/300\n");
		}

	}

}
