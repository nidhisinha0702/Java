package SlidingWindow;

public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 7, nums[] = {2,3,1,2,4,3};
		System.out.println("Miminum size subarray length equal to target is : "+minSubArrayLen(target, nums));

	}
	public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int low = 0, high = 0, sum = 0;
        int result = Integer.MAX_VALUE;

        while(high < n){
            sum += nums[high];
            while(sum >= target){
                int len = high - low + 1;
                result = Math.min(len, result);
                sum -= nums[low];
                low++;
            }
            high++;
        }
        return result == Integer.MAX_VALUE ? 0: result;
    }
}
