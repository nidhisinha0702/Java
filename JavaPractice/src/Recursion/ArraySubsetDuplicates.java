package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraySubsetDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,2,2,4,4,3};
		ArrayList<Integer> subset = new ArrayList<>();
		ArrayList<ArrayList<Integer>> allset = new ArrayList<>();
		//sort the array
		Arrays.sort(arr);
		getAllSubset(arr, subset, 0, allset);
		System.out.println(allset);
	}
	
	private static void getAllSubset(int arr[], ArrayList<Integer> ans, int i, ArrayList<ArrayList<Integer>> subsets) {
		//bc
		if(i == arr.length) {
			//store subsets
			subsets.add(new ArrayList<>(ans));
			return;
		}
		
		//include
		ans.add(arr[i]);
		getAllSubset(arr, ans, i+1, subsets);
		//backtrack
		ans.remove(ans.size()-1);//pop the same value which was added in the previous step
		//skip duplicate
		int idx = i + 1;//place the index at next element
		while(idx < arr.length && arr[idx] == arr[idx - 1])//keep comparing with previous index
			idx++;
		//exclude call with new index
		getAllSubset(arr, ans, idx, subsets);
	}

}
