package ClosedLabBook;

import java.util.Scanner;

public class ConvertNumberintoWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the Number\n");
		int n=sc.nextInt();
		check(n);

	}
	public static void check(int n) {
		if(n<10) {
			oneS(n);
		}
		else if(n<100) {
			tenS(n);
		}
		else if(n<1000) {
			hundred(n);
		}
		else if(n<100000) {
			thousand(n);
		}
		else {
			System.out.println("--");
		}
	}
	public static void oneS(int n) {
		if(n==0)
			return;
		String[] ones = {"zero","one","two","three","four","five","six","seven","eight","nine"};
		System.out.print(ones[n]);
	}
	public static void tenS(int n) {
		String[] tens = {"ten","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
		int t=n/10;
		System.out.print(tens[t-1]+" ");
		if(n%10>0) {
			check(n%10);
		}
	}
	public static void hundred(int n) {
		int h=n/100;
		oneS(h);
		System.out.print(" hundred ");
		if(n%100>0) {
			check(n%100);
		}
	}
	public static void thousand(int n) {
		if(n<10000) {
			int oneThd = n/1000;
			oneS(oneThd);
		}
		else {
			int tensThd = n/1000;
			tenS(tensThd);
		}
		System.out.print(" thousand ");
		if(n%1000>0) {
			check(n%1000);
		}
	}
	

}
