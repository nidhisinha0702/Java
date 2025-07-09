package Sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {20, 24, 2, 87, 25, 1};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	//TC(avg/best) O(nlogn) (worst case) -O(n^2), SC->O(n)
	private static void quickSort(int arr[], int st, int end) {
		if(st < end) {
			int pivInd = partition(arr, st, end);
			quickSort(arr, st, pivInd - 1);//left half
			quickSort(arr, pivInd + 1, end);//right half
		}
	}
	
	private static int partition(int arr[], int st, int end) {
		int idx = st - 1;
		int pivot = arr[end];
		//iterate over the array
		for(int j=st;j<end;j++) {
			if(arr[j] <= pivot) {
				idx++;
				//swap
				swap(arr, j, idx);
			}
		}
		idx++;
		swap(arr, end, idx);
		return idx;
	}
	
	private static void swap(int arr[], int l, int r) {
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}
	

}
