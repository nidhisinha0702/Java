package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 0, nums[] = {1,0,-1,0,-2,2};
		System.out.println("Four sum : "+fourSum(nums, target));

	}
	//Tc->O(nlogn + n ^3) SC-> O(uniqueQuadraples)
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        //sort
        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            //avoid duplicate nums[i]
            if(i > 0 && nums[i-1] == nums[i]) continue;
            for(int j=i+1;j<n;){
                int p = j+1, q = n-1;
                while(p<q){
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[p] + (long)nums[q];

                    if(sum < target) p++;
                    else if(sum > target) q--;
                    else {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]); quad.add(nums[j]); quad.add(nums[p]); quad.add(nums[q]);
                        ans.add(quad);
                        p++;q--;
                        //avoid duplicate values of nums[p]
                        while(p < q && nums[p] == nums[p-1]) p++;
                    }
                }
                j++;
                //avoid duplicate nums[j]
                while(j < n && nums[j-1] == nums[j]) j++;
            }
        }

        return ans;
    }
}
