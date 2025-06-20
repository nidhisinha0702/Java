package Search;

public class PeakInMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				int arr[] = {1,2,3,4,5,6,5,4,2};
				int low = 0;
				int high = arr.length - 1;
				
				System.out.println(" The ele is present at index : "+binarySearch(arr, low, high)); 
				

	}
			
	private static int binarySearch(int arr[], int low, int high) {
				
				while(low < high) {
					int mid = low + (high - low)/2;
					if(arr[mid] < arr[mid + 1])
						low = mid + 1;
					else
						high = mid;
					
				}
				return low;
	}
}
