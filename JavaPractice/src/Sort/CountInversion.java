package Sort;

import java.util.ArrayList;

public class CountInversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {6,3,5,2,7};
		int ans = mergeSort(arr, 0, arr.length - 1);
		System.out.println(ans);
	}
	
	private static int mergeSort(int arr[], int low, int high) {
		
		if(low < high) {
		int mid = low + (high - low) / 2; //avoid integer overflow condition
		
		int leftCount = mergeSort(arr, low, mid);
		int rightCount = mergeSort(arr, mid + 1, high);
		int invCount = merge(arr, low, mid, high);
		
		return leftCount + rightCount + invCount;
		}return 0;
	}
	
	private static int merge(int arr[], int low, int mid, int high) {
		ArrayList<Integer> temp = new ArrayList<>();
		int left = low;
		int right = mid + 1;
		int invCnt = 0;
		while(left <= mid && right <= high) {
			if(arr[left] <= arr[right]) {
				temp.add(arr[left]);
				left++;
			}else {
				temp.add(arr[right]);
				invCnt += (mid - left + 1);
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
		for(int i=0;i<temp.size();i++) {
			arr[i + low] = temp.get(i);
		}
		return invCnt;
	}

}
