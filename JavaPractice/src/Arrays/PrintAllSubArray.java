package Arrays;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubArray {
	
	public static void main(String args[]) {
		//ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		int arr[] = {1,2,3};
		List<List<Integer>> ans = getSubArrays(arr);
		System.out.println(ans);
	}
	 public static List<List<Integer>> getSubArrays(int[] arr) {
	        // code here
	        List<List<Integer>> allSubArrays = new ArrayList<>();
	        //List<Integer> subArrays = new ArrayList<>();
	        int n = arr.length;
	        solve(0, 0, arr, allSubArrays);
	        return allSubArrays;
	    }
	    
	    private static void solve(int stIdx, int endIdx, int arr[], List<List<Integer>> allSubArrays){
	        //bc
	        if(endIdx == arr.length){
	            if(stIdx < arr.length){
	                solve(stIdx + 1, stIdx + 1, arr, allSubArrays);
	            }return;
	        }
	        
	        List<Integer> temp = new ArrayList<>();
	        for(int i=stIdx;i<=endIdx;i++){
	            temp.add(arr[i]);
	        }
	        
	        allSubArrays.add(temp);
	        solve(stIdx, endIdx+1, arr, allSubArrays);
	    }
}
