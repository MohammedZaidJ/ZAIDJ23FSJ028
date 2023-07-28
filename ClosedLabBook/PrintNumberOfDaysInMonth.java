package ClosedLabBook;

import java.util.Scanner;

public class PrintNumberOfDaysInMonth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the year\n");
		int year=sc.nextInt(),checkLeap = 0;
		if((year%4==0 && year%100!=0) || year%400==0) {
			checkLeap++;
		}
		System.out.println("Enter the Month");
		String str=sc.next();
		switch(str.toLowerCase()) {
		case "january":{
			System.out.println("31");
			break;
		}
		case "february":{
			System.out.println(28+checkLeap);
			break;
		}
		case "march":{
			System.out.println("31");
			break;
		}
		case "april":{
			System.out.println("30");
			break;
		}
		case "may":{
			System.out.println("31");
			break;
		}
		case "june":{
			System.out.println("30");
			break;
		}
		case "july":{
			System.out.println("31");
			break;
		}
		case "august":{
			System.out.println("31");
			break;
		}
		case "September":{
			System.out.println("30");
			break;
		}
		case "october":{
			System.out.println("31");
			break;
		}
		case "november":{
			System.out.println("30");
			break;
		}
		case "december":{
			System.out.println("31");
			break;
		}
		default:{
			System.out.println("Enter vaild input");
			break;
		}
		}

	}

}
