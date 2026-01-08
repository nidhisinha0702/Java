package prefixSum;

import java.util.HashMap;
import java.util.Map;
//Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
public class ContigousArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {0,1,0};
		System.out.println("Maximum length of contigous subarray with equal zero and one: "+findMaxLength(nums));
	}
	public static int findMaxLength(int[] nums) {
        int n = nums.length;
        int zero = 0, one = 0, res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(nums[i] == 0)
                zero++;
            else one++;
            int diff = zero - one;
            if(diff == 0){
                res = Math.max(res, i+1);
                continue;
            }
            if(!map.containsKey(diff)){
                map.put(diff, i);
            }else{
                int idx = map.get(diff);
                res = Math.max(res, i-idx);
            }
        }return res;
    }
}
