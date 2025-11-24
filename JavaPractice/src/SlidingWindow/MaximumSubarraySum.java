package SlidingWindow;

public class MaximumSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 4, 2, 10, 23, 3, 1, 0, 20}, k = 4;
		System.out.println("Maximum subarray sum is : "+maxSubarraySum(arr, k));

	}
	
	public static int maxSubarraySum(int[] arr, int k) {
        // Code here
        int low = 0, high = k-1;
        int n = arr.length;
        int sum = 0;
        
        for(int i=low;i<=high;i++){
            sum += arr[i];
        }
        
        int res = Integer.MIN_VALUE;
        while(high<n){
            res = Math.max(res, sum);
            low++;
            high++;
            
            if(high == n)
                break;
            sum = sum - arr[low-1] + arr[high]; 
        }
        return res;
    }

}
