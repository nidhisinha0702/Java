package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,5};
		int target = 8;
		Set<List<Integer>> ans = new HashSet<>();
		List<Integer> comb = new ArrayList<>();
		getAllCombination(arr, 0, target, ans, comb);
		System.out.println(ans);

	}
	
	//TC-> O(3^n)
	private static void getAllCombination(int arr[], int idx, int target, Set<List<Integer>> ans, List<Integer> comb) {
		//bc
		if(idx == arr.length || target < 0)
			return;
		
		if(target == 0) {
			ans.add(new ArrayList<>(comb));
			return;
		}
		
		comb.add(arr[idx]);
		//single 
		getAllCombination(arr, idx + 1, target - arr[idx], ans, comb);
		//multiple
		getAllCombination(arr, idx, target - arr[idx], ans, comb);
		//backtrack
		comb.remove(comb.size() - 1);
		getAllCombination(arr, idx + 1, target, ans, comb);
	}

}
