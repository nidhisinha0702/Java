package Sort;

import java.util.Arrays;

public class SelectionSort {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int arr[] = {4,1,5,2,3};
			int n = arr.length;
			selection(arr,n);
			System.out.println(Arrays.toString(arr));
		}
		//TC->O(n^2)
		private static void selection(int arr[], int n) {
			//it runs for n-1 iteration and put smallest element to front
			for(int i=0;i<n-1;i++) {
				int smallIdx = i;
				for(int j=i+1;j<n;j++) {
					//compare each element with smallIdx value to find the smallest value
					if(arr[j] < arr[smallIdx]) {
						smallIdx = j;
					}
				}
				//swap i and smallIdx
				int temp = arr[i];
				arr[i] = arr[smallIdx];
				arr[smallIdx] = temp;
			}
		}
}
