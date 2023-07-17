package OpenLabBook;

public class SumArray {
	public static void main(String args[]){
		int[] array = {23,22,436,3,23,19};
		int sum = 0;
		for( int num : array) {
			sum = sum+num;
		}
		System.out.println("Sum of array elements is:"+sum);
		}
}
