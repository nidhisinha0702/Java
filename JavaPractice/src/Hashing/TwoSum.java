package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,7,11,15}, target = 9;
		System.out.println(Arrays.toString(twoSum(arr, target)));
	}
	//TC->O(n)
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int first = nums[i];
            if(mpp.containsKey(target-first)){
                return new int[]{i, mpp.get(target-first)};
            }mpp.put(first, i);
        }return new int[]{-1,-1};
    }
}
