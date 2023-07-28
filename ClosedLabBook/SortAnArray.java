package ClosedLabBook;

public class SortAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {23,56,78,53,23,45,76,46};
		int n=8;
		System.out.println("Before sorting array");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("\n\nAscending order sorting array");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i]<arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("\n\nDescending order sorting array");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
