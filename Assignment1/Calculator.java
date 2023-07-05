package Assignment1;


public class Calculator {
	public int add(int a,int b) {
		return a+b;
	}
	public int sub(int a,int b) {
		return a-b;
	}
	public int mul(int a,int b) {
		return a*b;
	}
	public int div(int a,int b) {
		if(b==0 || a==0) {
			System.out.print("zero can't be divided... ");
			return 0;
		}
		return a/b;
	}

	public int power(int a,int b) {
		int num=a;
		while(b!=0) {
			num*=a;
			b--;
		}
		return num;
	}
	public int square(int a) {
		return a*a;
	}

	public int modulus(int a,int b) {
		return a%b;
	}

	public int factorial(int a) {
		int num=1,temp=1;
		while(a!=0) {
			num*=temp;
			temp++;
			a--;
		}
		return num;
	}	

}
