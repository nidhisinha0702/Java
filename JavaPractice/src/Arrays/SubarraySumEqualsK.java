package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3}, k = 3;
		System.out.println("number of subarray sum equals k :"+subarraySum(arr, k));
	}
	//Tc->O(n), SC->O(n)
	public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int preSum[] = new int[n];

        //find the prefix sum array
        preSum [0] = nums[0];
        for(int i=1;i<n;i++){
            preSum[i] = preSum[i-1] + nums[i];
        }

        //run a loop on array and count
        //{prefixSum,freq}
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int j=0;j<n;j++){
            if(preSum[j] == k) count++;
            int val = preSum[j] - k;
            if(mpp.containsKey(val)){
                count += mpp.get(val);
            }
            mpp.put(preSum[j], mpp.getOrDefault(preSum[j], 0)+1);
        }

        return count;
    }
}
