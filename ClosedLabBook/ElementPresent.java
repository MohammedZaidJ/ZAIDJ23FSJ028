package ClosedLabBook;

import java.util.Scanner;

public class ElementPresent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = {23,56,78,53,23,45,76,46};
		int n = sc.nextInt();
		int check=0,index=0;
		for(int i=0;i<8;i++) {
			if(arr[i]==n) {
				check=1;
				index=i;
			}
		}
		if(check==1) {
			System.out.println("element present at "+ index);
		}
		else {
			System.out.println("element not present");
		}
	}

}
