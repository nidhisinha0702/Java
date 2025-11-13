package TwoPointer;

import java.util.Arrays;

public class _3SumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,2,1,-4};
		int target = 1;
		System.out.println("Closest sum of triplet is : "+threeSumClosest(nums, target));

	}
	public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int result = 0;
        int maxdiff = Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++){
            int left = i+1;
            int right = n-1;
            
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                int diff = Math.abs(sum - target);
                if(diff < maxdiff){
                    maxdiff = diff;
                    result = sum;
                }
                if(sum == target){
                    left++;
                    right--;
                }else if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }return result;
    }

}
