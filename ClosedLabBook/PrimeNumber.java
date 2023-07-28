package ClosedLabBook;

public class PrimeNumber {

	public static void main(String[] args) {
		System.out.println("Prime number list between 1 to 100");
		for(int check=1;check<101;check++) {
			int temp=0;
			for(int j=1;j<check;j++) {
				if(check%j==0) {
					temp++;
				}
			}
			if(temp==1) {
				System.out.println(check);
			}
		}

	}

}
