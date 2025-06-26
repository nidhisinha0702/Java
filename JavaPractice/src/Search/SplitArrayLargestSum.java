package Search;

import java.util.Arrays;
//Painter Partition problem/ Book allocation problem
public class SplitArrayLargestSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {7,2,5,10,8};
		int k = 2;
		int ans = splitArray(nums, k);
		System.out.println("Arrays min of maximum sum is : "+ans);

	}
	//TC->O(nlogN)-N(range of min to max)
	public static int splitArray(int[] nums, int k) {
        //minimize the largest sum
        //we can divide the array into non-empty subarray
        //edge case
        int n = nums.length;
        if(k > n) return -1;
        
        int start = Arrays.stream(nums).min().getAsInt();//minmum is the min value of all the elements
        int end = 0;
        for(int i=0;i<n;i++)
        end += nums[i];
        int ans = -1;
        //my search space for max possible sum is sorted
        //apply binary search
        while(start <= end){
            int mid = start + (end - start)/2;

            //valid ans
            if(isValid(nums, n, k, mid)){
                ans = mid;
                //left
                end = mid - 1;
            }else{//invalid ans
                //right
                start = mid + 1;
            }
        }return ans;
    }

    private static boolean isValid(int arr[], int n, int k, int maxAllowedSum){
        int parts = 1, sum = 0;
        //for contiguous allocation iterate
        for(int i=0;i<n;i++){
            //edge case
            if(arr[i] > maxAllowedSum){
                return false;
            }
            if(sum + arr[i] <= maxAllowedSum){
                sum += arr[i];
            }else{
                parts++;
                sum = arr[i];
            }
        }

        return (parts > k) ? false:true;
    }
}
