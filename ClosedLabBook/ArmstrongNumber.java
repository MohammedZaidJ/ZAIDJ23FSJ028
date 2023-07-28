package ClosedLabBook;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Number");
		int n=sc.nextInt();
		int len=0,dubN=n;
		while(dubN!=0) {
			dubN/=10;
			len++;
		}
		int checkN=0;
		dubN=n;
		while(dubN!=0) {
			checkN+=power(dubN%10,len);
			dubN/=10;
		}
		if(checkN==n) {
			System.out.println("It is Armstrong Number");
		}
		else {
			System.out.println("It is not Armstrong Number");
		}

	}

	private static int power(int i,int len) {
		int num=1;
		while(len!=0) {
			len--;
			num*=i;
		}
		return num;
	}

}
