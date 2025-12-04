package SlidingWindow;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  nums = {1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;
		System.out.println("Length of maximum consecutive ones after k 0 replacement : "+longestOnes(nums, k));

	}
	public static int longestOnes(int[] nums, int k) {
        int low = 0, high = 0, n = nums.length;
        int freq[] = new int[2];
        int maxLen = Integer.MIN_VALUE;
        while(high < n){
            freq[nums[high]]++;
           
            while(freq[0] > k){
                freq[nums[low]]--;
                low++;
            }
            int len = high - low + 1;
            maxLen = Math.max(maxLen, len);
            high++;
        }return maxLen;
    }
}
