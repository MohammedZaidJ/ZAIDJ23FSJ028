package Assignment2;

public class Recursion {

	public static int factorialCalculation(int num) {
		if(num==0) {
			return 1;
		}
		return num*factorialCalculation(num-1);
	}
	
	public static void fibonacciSeries(int num) {
		int a=0,b=1;
		for(int i=0;i<num;i++) {
			System.out.println(a+b);
			int t=b;
			b=a+b;
			a=t;
		}
	}
	public static int sumOfDigits(int num) {
		if(num==0) {
			return 0;
		}
		return (num%10)+sumOfDigits(num/10);
	}

	public static void palindromeCheck(String str){
		int len=str.length();
		for(int i=0;i<len/2;i++) {
			if(str.charAt(i)!=str.charAt(len-i-1)) {
				System.out.println("Not a Palindrome");
				break;
			}
		}
		System.out.println("Is a Palindrome");
	}
	public static void towerOfHanio(int n,char begin,char end,char intmid) {
		if(n==1) {
			System.out.printf("--moving disk 1 %c to %c\n",begin,end);
			return;
		}
		towerOfHanio(n-1,begin,intmid,end);
		System.out.printf("moving disk %d %c to %c\n",n,begin,end);
		towerOfHanio(n-1,intmid,end,begin);
		
	}
	public static int binarySearch(int[] arr,int x,int front,int end){
int mid = (front + end) / 2;
		if(arr[mid]==x) {
			return arr[mid];
		}
		else if(x>arr[mid]) {
			System.out.println("front");
			return binarySearch(arr,x,mid+1,end);
		}
		else {
			System.out.println("back");
			return binarySearch(arr,x,front,mid-1);
		}
	}
	
	public static int gcd(int n) {
		int mid=n/2;
		while(mid>1) {
			if(n%mid==0) {
				return mid;
			}
			mid--;
		}
		return 0;
	}
	public static void permutation(String s) {
		// TODO Auto-generated method stub
		int str = 1,p=0, ed = s.length();
		for(int i=0;i<ed;i++) {
			for(int j=0;j<ed-1;j++) {
				swapAndPrint(str,p,ed,s);
				System.out.println();
				str++;
			}
			p++;
			str=0;
		}
	}
	public static void swapAndPrint(int str,int p,int ed,String s) {
		System.out.print(s.charAt(p));
		for(int i=0;i<ed;i++) {
			if(str==ed) {
				str=0;
			}
			if(p!=str) {
				System.out.print(s.charAt(str));
			}
			str++;
		}
	}
	
	
	public static void main(String[] args) {
//		Factorial Calculation
		System.out.println("Fibonacci Series of 5");
		fibonacciSeries(5);
		
//		Fibonacci Series
		System.out.println("\n\nFactorial Calculation of 5");
		System.out.println(factorialCalculation(5));
		
//		Sum of Digits
		System.out.println("\n\nSum Of Digits  3536");
		System.out.println(sumOfDigits(3536));
		
//		Palindrome Check
		System.out.println("\n\nPalindrome Check 2002");
		palindromeCheck("2002");
		
//		Tower of Hanoi
		System.out.println("\n\nTower of Hanoi 3");
		towerOfHanio(3,'A','C','B');
		
//		Binary Search
		System.out.println("\n\nBinary Search");
		int[] arr = {1,2,3,4,5};
		int result = binarySearch(arr,2,0,4);
		if(result==2) {
			System.out.printf("Element find in the Index of %d",arr[result]);
		}
		else {
			System.out.println("Element Not find?");
		}
		
		
//		greatest common divisor (GCD)
		System.out.println("\n\ngreatest common divisor (GCD)");
		int gcd = gcd(88);
		if(gcd==0) {
			System.out.println("Element Not find?");
			}
		else {
			System.out.printf("greatest common divisor of %d is %s",88,gcd);
		}
		
//		permutations or combinations of a set of elements
		
		String str1 = "ABCD";
		permutation(str1);
		
	}

	

}
