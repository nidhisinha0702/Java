package Search;

public class SingleElementSortedElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,1,2,2,3,4,4,5,5};
		System.out.println("The single element is : "+single(arr));
	}
	
	private static int single(int arr[]) {
		//edge case
		int n = arr.length;
		if(n == 1) return arr[0];
		
		int st = 0, end = n - 1;
		while(st <= end) {
			int mid = st + (end - st)/2;
			
			//if mid lies on 1st and last element
			if(mid == 0 && arr[mid] != arr[mid + 1]) return arr[mid];
			if(mid == n-1 && arr[mid] != arr[mid - 1]) return arr[mid];
			
			if(arr[mid - 1] != arr[mid] && arr[mid] != arr[mid + 1]) return arr[mid];
			
			//even case
			if(mid % 2 == 0) {
				if(arr[mid - 1] == arr[mid]) {
					end = mid - 1;//left
				}else {
					st = mid + 1;//right
				}
			}else {//odd case
				if(arr[mid - 1] == arr[mid]) {
					st = mid + 1;//right
				}else {
					end = mid + 1;//left
				}
			}
		}return -1;
	}

}
