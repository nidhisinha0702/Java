package prefixSum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,1,1};
		int k = 2;
		System.out.println("Subarray sum equals k count is : "+subarraySum(nums, k));

	}
	public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int n = nums.length;
        int res = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            int q = sum - k;
            int freq = 0;
            if(map.containsKey(q))
            freq = map.get(q);
            res += freq;
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }return res;
    }
}
