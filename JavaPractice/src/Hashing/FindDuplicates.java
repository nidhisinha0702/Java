package Hashing;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {4,3,2,7,8,2,3,1};
		System.out.println(findDuplicates(arr));

	}
	public static List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> dup = new ArrayList<>();
        for(int i=0;i<n;i++){
            int idx = Math.abs(nums[i]) - 1;

            if(nums[idx] < 0){
                dup.add(Math.abs(nums[i]));
            }else{
                nums[idx] = -nums[idx];
            }
        }return dup;
    }
}
