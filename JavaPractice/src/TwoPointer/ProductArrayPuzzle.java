package TwoPointer;

import java.util.Arrays;

public class ProductArrayPuzzle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4};
		int answer[] = productExceptSelf(arr);
		System.out.println(Arrays.toString(answer));

	}
	//TC->O(n)
	 public static int[] productExceptSelf(int arr[]) {
	        // code here
	        int n = arr.length;
	        int ans[] = new int[n];
	        //prefix
	        int prefix = 1;
	        ans[0] = prefix;
	        for(int i=1;i<n;i++){
	            ans[i] = prefix * arr[i-1];
	            prefix = ans[i];
	            
	        }
	        //suffix
	        int suffix = 1;
	        for(int i=n-2;i>=0;i--){
	            suffix *= arr[i+1];
	            ans[i] *= suffix;
	        }
	        return ans;
	    }
}
