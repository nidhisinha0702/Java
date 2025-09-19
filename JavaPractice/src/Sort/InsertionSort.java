package Sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
			int arr[] = {4,1,5,2,3};
			int n = arr.length;
			insertion(arr,n);
			System.out.println(Arrays.toString(arr));
		}
		//TC->O(n^2) O(n) -(best case)
		private static void insertion(int arr[], int n) {
			//insert a new element at its correct position
			for(int i=0;i<=n-1;i++) {
				int j = i;
				while(j > 0 && arr[j-1] > arr[j]) {
					//swap
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					j--;
				}
			}
		}
}
