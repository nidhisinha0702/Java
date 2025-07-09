package Search;

import java.util.Arrays;

public class FirstLastOccrurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {5,7,7,8,8,10};
		int target = 8;
		int ans[] = searchRange(nums, target);
		System.out.println(Arrays.toString(ans));

	}
	 public static int[] searchRange(int[] nums, int target) {

	        int ans[] = {-1, -1};
	        //check for 1st occurrence
	        ans[0] = search(nums, target, true);
	      //check for 2st occurrence
	        ans[1] = search(nums, target, false);
	        return ans;
	    }
	       

	    private static int search(int[] nums, int target, boolean findStartIndex){
	        int start = 0;
	        int end = nums.length - 1;
	        int ans = -1;
	        while(start <= end){
	            int mid = start + (end - start)/2;

	            if(target < nums[mid]){
	                end = mid - 1;
	            }else if(target > nums[mid]){
	                start = mid + 1;
	            }else{
	            	//potential ans
	                ans = mid;
	                //search in left
	                if(findStartIndex){
	                    end = mid - 1;
	                }else{//otherwise right
	                    start = mid + 1;
	                }
	            }
	        }return ans;
	    }
}
