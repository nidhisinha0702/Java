package Sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
			int arr[] = {4,1,5,2,3};
			int n = arr.length;
			insertion(arr,n);
			System.out.println(Arrays.toString(arr));
		}
		//TC->O(n^2)
		private static void insertion(int arr[], int n) {
			//insert a new element at its correct position
			for(int i=1;i<n;i++) {
				int curr = arr[i];
				int prev = i-1;
				while(prev >=0 && arr[prev] > curr) {
					//push the greater elements to the end and create an empty space to be filled by the curr
					arr[prev + 1] = arr[prev];
					prev--;
				}
				arr[prev+1] = curr;
			}
		}
}
