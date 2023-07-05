package Assignment1;

import java.util.Scanner;

public class Calculator {
	public static int add(int a,int b) {
		return a+b;
	}
	public static int sub(int a,int b) {
		return a-b;
	}
	public static int mul(int a,int b) {
		return a*b;
	}
	public static int div(int a,int b) {
		if(b==0 || a==0) {
			System.out.print("zero can't be divided... ");
			return 0;
		}
		return a/b;
	}

	public static int power(int a,int b) {
		int num=a;
		while(b!=0) {
			num*=a;
			b--;
		}
		return num;
	}
	public static int square(int a) {
		return a*a;
	}

	public static int modulus(int a,int b) {
		return a%b;
	}

	public static int factorial(int a) {
		int num=1,temp=1;
		while(a!=0) {
			num*=temp;
			temp++;
			a--;
		}
		return num;
	}	
	public static void main(String[] args) {
		boolean stopLoop = true;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("1.Addition\n"
					         + "2.Subtraction\n"
					         + "3.Multipliaction\n"
					         + "4.Division\n"
					         + "5.Power Calculatioin \n"
					         + "6.Square Root\n"
					         + "7.Modulus\n"
					         + "8.Factorial of a Number\n"
					         + "0.exit\n"
					         + "Enter your choice");
			
			int input;
			try {
				input = Integer.parseInt(sc.nextLine());
			}
			catch(Exception e) {
				System.err.println("Enter the valid Input");
				continue;
			}
			System.out.print("Enter the First Number : ");
			int a;
			try {
				a = Integer.parseInt(sc.nextLine());
			}
			catch(Exception e) {
				System.err.println("Enter the valid Input");
				continue;
			}
			int b=0;
			if(input!=6 && input!=8){
				System.out.print("Enter the Second Number : ");
				try {
					b = Integer.parseInt(sc.nextLine());
				}
				catch(Exception e) {
					System.err.println("Enter the valid Input");
					continue;
				}
			}
			switch(input){
				case 1:{
					System.out.println(add(a,b));
					break;
				}
				case 2:{
					System.out.println(sub(a,b));				
					break;
				}
				case 3:{
					System.out.println(mul(a,b));									
					break;
				}
				case 4:{
					System.out.println(div(a,b));
					break;
				}
				case 5:{
					System.out.println(power(a,b));				
					break;
				}
				case 6:{
					System.out.println(square(a));
					break;
				}
				case 7:{
					System.out.println(modulus(a,b));
					break;
				}
				case 8:{
					System.out.println(factorial(a));
					break;
				}
				case 0:{
					stopLoop=false;
					break;
				}
				default:{
					System.out.println("Enter the Valid Input");
					break;
				}
			}
			
			
		}while(stopLoop);
		
	}

}
