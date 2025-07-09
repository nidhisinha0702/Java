package Search;

public class OrderAgnosticBS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {10, 9, 5, 4, 2, 0};
		int target = 4;
		System.out.println("target is found at : "+orderBS(arr, target));

	}
	
	//TC->O(logn)
	static int orderBS(int arr[], int target) {
		int start = 0;
		int end = arr.length - 1;
		
		//find asc/desc
		boolean isAsc = arr[start] < arr[end];
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] == target)
				return mid;
			
			if(isAsc) {
				if(target < arr[mid]) {
					end = mid - 1;
				}else {
					start = mid + 1;
				}
			}else {
				if(target < arr[mid]) {
					start = mid + 1;
				}else {
					end = mid - 1;
				}
			}
		}return -1;
	}

}
