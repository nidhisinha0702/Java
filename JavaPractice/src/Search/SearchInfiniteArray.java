package Search;

public class SearchInfiniteArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170}, k = 10;
		System.out.println("target is found at ind: "+findingRange(arr, k));
		
	}
	
	private static int findingRange(int arr[], int target) {
		//first find the range
		//start with box of size 2
		int start = 0;
		int end = 1;
		
		//condition for the target to lie in the range, we will keep doubling the range till target > end
		while(target > arr[end]) {
			int newStart = end + 1;
			//newend = prev end + 2 * size of the window
			int newEnd = end + (end - start + 1) * 2;
			start = newStart;
			end = newEnd;
		}
		
		return search(arr, start, end, target);
		
	}
	
	private static int search(int arr[], int start, int end, int target) {
		while(start <= end) {
			int mid = start + (end - start)/2;
			if(arr[mid] == target)
				return mid;
			else if(arr[mid] > target) {
				end = mid - 1;
			}else
				start = mid + 1;
		}
		return -1;
	}

}
