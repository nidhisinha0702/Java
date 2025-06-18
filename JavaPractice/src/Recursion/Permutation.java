package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		// WAP to find all the permutation of an array
		int nums[] = {1,2,3};
		List<List<Integer>> ans = new ArrayList<>();
		getPerms(nums, 0, ans);
		System.out.println(ans);

	}
	
	private static void getPerms(int nums[], int idx, List<List<Integer>> ans) {
		//bc
		if(idx == nums.length) {
			ans.add(convertArrayToList(nums));
		}
		
		for(int i=idx;i<nums.length;i++) {
			//swap the position in the same array
			swap(idx, i, nums);
			getPerms(nums, idx + 1, ans);
			//backtrack
			swap(idx, i, nums);
		}
	}
	
	private static void swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	private static List<Integer> convertArrayToList(int[] arr) {
		List<Integer> list = new ArrayList<>();
		for(int num:arr) {
			list.add(num);
		}return list;
	}

}
