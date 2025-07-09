package Search;

public class PeakInMountainArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				int arr[] = {1,2,3,4,5,6,5,4,2};
				//peak can not be on 0 and last idx and avoid unnecessary checks
				int low = 1;
				int high = arr.length - 2;
				
				System.out.println(" The ele is present at index : "+binarySearch(arr, low, high)); 
				

	}
			
	private static int binarySearch(int arr[], int start, int end) {
				
			while(start <= end) {
				int mid = start + (end - start)/2;
				//check for peak element
				if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid + 1])
					return mid;
				if(arr[mid-1] < arr[mid])//increasing slope
					start = mid + 1;
				else //decreasing slope
					end = mid - 1;
			}return -1;
	}
}
