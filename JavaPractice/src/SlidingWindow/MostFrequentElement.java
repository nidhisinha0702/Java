package SlidingWindow;

import java.util.Arrays;

public class MostFrequentElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,4,8,13};

	}
	public int maxFrequency(int[] nums, int k) {
        //sort+prefixSum+sliding window
        //sort because we can increase with +1
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, ans = 0;
        long currSum = 0;
        //we have to check all the window and convert all the element to the maximum element(curr element) as array is sorted
        for(int r=0;r<n;r++){
            currSum += nums[r];
            //windLen * currEle(maxEle) <= currSum + k it is valid
            //else shrink the window
            if((r-l+1L) * nums[r] > currSum + k){
                currSum -= nums[l];
                l++;
            }

            ans = Math.max(ans, (r-l+1));
        }
        return ans; 
    }
}
