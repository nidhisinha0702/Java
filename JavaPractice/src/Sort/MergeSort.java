package Sort;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// WAP that illustrates merge sort
		int arr[] = {70,50,30,1000,20,40,60};
		int n = arr.length;
		mergeSort(arr, 0, n-1);
		System.out.println(Arrays.toString(arr));

	}
	
	//TC->O(nlogn), SC->O(n)
	private static void mergeSort(int arr[], int low, int high) {
		
		if(low>=high) return;
		int mid = low + (high - low) / 2; //avoid integer overflow condition
		
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}
	
	private static void merge(int arr[], int low, int mid, int high) {
		ArrayList<Integer> temp = new ArrayList<>();
		int left = low;
		int right = mid + 1;
		while(left <= mid && right <= high) {
			if(arr[left] <= arr[right]) {
				temp.add(arr[left]);
				left++;
			}else {
				temp.add(arr[right]);
				right++;
			}
		}
		while(left <= mid) {
			temp.add(arr[left]);
			left++;
		}
		while(right <= high) {
			temp.add(arr[right]);
			right++;
		}
		
		//put the elements back in array
		for(int i=low;i<=high;i++) {
			arr[i] = temp.get(i-low);
		}
	}

}
