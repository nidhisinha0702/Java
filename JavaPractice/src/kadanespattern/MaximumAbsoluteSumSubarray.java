package kadanespattern;

public class MaximumAbsoluteSumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,-3,2,3,-4};
		System.out.println("Maximum absolute sum subarray is : "+maxAbsoluteSum(nums));

	}

	public static int maxAbsoluteSum(int[] nums) {
        //abs of minSum will also give positive value so calculate both
        int minEnd = 0;
        int maxEnd = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            maxEnd = Math.max(nums[i], maxEnd+nums[i]);
            minEnd = Math.min(nums[i], minEnd+nums[i]);
            maxSum = Math.max(maxEnd, maxSum);
            minSum = Math.min(minEnd, minSum);
        }
        return Math.max(Math.abs(maxSum), Math.abs(minSum)); 
    }
}
