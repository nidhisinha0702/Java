package prefixSum;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubarraySumDivByK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {4,5,0,-2,-3,1}, k = 5;
		System.out.println("Number of subarray whose sum is divisible by k :"+subarraysDivByK(nums, k));

	}
	 public static int subarraysDivByK(int[] nums, int k) {
	        int sum = 0, res = 0;
	        Map<Integer, Integer> map = new HashMap<>();
	        int n = nums.length;
	        map.put(0,1);
	        for(int i=0;i<n;i++){
	            sum += nums[i];
	            int rem = sum % k;
	            if(rem < 0)
	                rem = rem + k;
	            if(map.containsKey(rem))
	                res += map.get(rem);
	            map.put(rem, map.getOrDefault(rem, 0)+1);

	        }return res;
	    }
}
