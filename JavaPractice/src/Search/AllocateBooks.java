package Search;

import java.util.Arrays;

public class AllocateBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {12, 34, 67, 90}, k = 2;
		System.out.println("Maximum allowed pages that is minimum : "+findPages(arr, k));

	}
	//TC->O(long Range * n)
	 public static int findPages(int[] arr, int k) {
	        // code here
	        if(k > arr.length) return -1;
	        int st = Arrays.stream(arr).min().getAsInt();
	        int end = 0;
	        for(int i=0;i<arr.length;i++){
	            end += arr[i];
	        }
	        int ans = -1;
	        while(st <= end){
	            int mid = st + (end - st)/2;
	            
	            if(isValid(mid, arr, k)){
	                //left
	                ans = mid;
	                end = mid - 1;
	            }else{
	                //right
	                st = mid + 1;
	            }
	        }return ans;
	    }
	    
	    private static boolean isValid(int maxAllowedPages, int arr[], int k){
	        int student = 1, pages = 0;
	        
	        for(int i=0;i<arr.length;i++){
	            //current element > maximum allowed pages
	            if(maxAllowedPages < arr[i]) return false;
	            if(arr[i] + pages <= maxAllowedPages){
	                pages += arr[i];//allocate pages
	            }else{
	                student++;//add new student
	                pages = arr[i];//reset the pages to current value
	            }
	        }
	        
	        return (student > k) ? false:true;
	    }
}
