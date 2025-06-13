package Recursion;

import java.util.ArrayList;

public class ArraySubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3};
		ArrayList<Integer> subset = new ArrayList<>();
		//func(0, arr, subset);
		ArrayList<ArrayList<Integer>> allset = new ArrayList<>();
		allSubset(0, arr, subset, allset);
		System.out.println(allset);

	}
	
	private static void func(int ind, int arr[], ArrayList<Integer> subset) {
		//base case
		if(ind == arr.length){
			System.out.println(subset);
			return;
		}
		
		//pick
		subset.add(arr[ind]);
		func(ind + 1, arr, subset);
		
		//backtracking step
		subset.remove(subset.size() - 1);
		//notpick
		func(ind + 1, arr, subset);
	}
	
	private static void allSubset(int ind, int arr[], ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> allset) {
		//base case
		if(ind == arr.length) {
			//store subset
			allset.add(new ArrayList<>(subset));
			return;
		}
		
		//include
		subset.add(arr[ind]);
		allSubset(ind + 1, arr, subset, allset);
		//backtrack
		subset.remove(subset.size() - 1);
		//exclude
		allSubset(ind + 1, arr, subset, allset);
	}

}
