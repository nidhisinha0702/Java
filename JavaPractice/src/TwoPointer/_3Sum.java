package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> triplets = threeSum(nums);
		System.out.println(triplets);

	}
	
	 public static List<List<Integer>> threeSum(int[] nums) {
	        int n = nums.length;
	        Arrays.sort(nums);
	        List<List<Integer>> ans = new ArrayList<>();
	        for(int i=0;i<n-2;i++){
	            if(i > 0 && nums[i] == nums[i-1]) continue;
	            int tar = -1*nums[i];
	            //perform 2 sum
	            int left = i+1;
	            int right = n-1;
	            while(left < right){
	                int s = nums[left] + nums[right];
	                if(s == tar){
	                    List<Integer> unique = new ArrayList<>();
	                    unique.add(nums[left]); unique.add(nums[right]); unique.add(nums[i]);
	                    ans.add(unique);
	                    left++;
	                    right--;
	                    while(left < right && nums[left] == nums[left-1])
	                    left++;
	                    while(left < right && nums[right] == nums[right+1])
	                    right--;
	                }else if(s < tar)
	                    left++;
	                else
	                    right--;
	            }
	        }return ans;
	    }

}
