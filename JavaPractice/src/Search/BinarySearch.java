package Search;

public class BinarySearch {

	public static void main(String[] args) {
		// WAP to implement binary search in java
		int arr[] = {1,2,3,4,5,6,7,8,9,10};
		int low = 0;
		int high = arr.length - 1;
		int key = 6;
		
		System.out.println(" The ele is present at index : "+binarySearchII(arr, low, high, key)); 
		

	}
	
	private static int binarySearch(int arr[], int low, int high, int key) {
		
		while(low<=high) {
			int mid = low + (high - low)/2;
			if(arr[mid] == key)
				return mid;
			else if(arr[mid] > key) {
				high = mid - 1;
			}else
				low = mid + 1;
		}
		return -1;
	}
	
	private static int binarySearchII(int arr[], int low, int high, int key) {
		
		if(low<=high) {
			int mid = low + (high - low)/2;
			if(arr[mid] == key)
				return mid;
			else if(arr[mid] > key) {
				return binarySearchII(arr, low, mid - 1, key);
			}else
				return binarySearchII(arr, mid + 1, high, key);
		}
		return -1;
	}

}
