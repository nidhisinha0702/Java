package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println("unique triplets are : "+threeSumIII(nums));

	}
	//TC->O(n^3) Brute
	public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Set<List<Integer>> s = new HashSet<>();//unique Triplets

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> trip = new ArrayList<>();
                        trip.add(nums[i]);trip.add(nums[j]);trip.add(nums[k]);
                        //sort to avoid duplicates
                        Collections.sort(trip);
                        if(!s.contains(trip)){
                            s.add(trip);
                            ans.add(trip);
                        }    
                    }
                }
            }
        }
        return ans;
    }
	//TC->(O(n^2)) Better
	public static List<List<Integer>> threeSumII(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Set<List<Integer>> uniqueTriplets = new HashSet<>();//unique Triplets

        for(int i=0;i<n;i++){
            //a+b+c = 0 //b+c = -a
            int tar = -nums[i];
            Set<Integer> s = new HashSet<>();
            for(int j=i+1;j<n;j++){
                //c = tar - b
                int third = tar-nums[j];
                    //if thris number exist in set
                    if(s.contains(third)){
                        List<Integer> trip = new ArrayList<>();
                        trip.add(nums[i]);trip.add(nums[j]);trip.add(third);
                        //avoid duplicates
                        Collections.sort(trip);
                        uniqueTriplets.add(trip);
                    }
                    s.add(nums[j]);
            }
        }
        for(List<Integer> l:uniqueTriplets){
            ans.add(l);
        }
        return ans;
    }
	//Tc->O(nlogn + n^2) SC->O(uniquetriplets)
	 public static List<List<Integer>> threeSumIII(int[] nums) {
	        int n = nums.length;
	        List<List<Integer>> ans = new ArrayList<>();
	    //sort
	        Arrays.sort(nums);
	        
	        for(int i=0;i<n;i++){
	            int j = i+1, k = n-1;
	            //avoidd duplicate nums[i]
	            if(i > 0 && nums[i] == nums[i-1]) continue;
	            while(j < k){
	                int sum = nums[i] + nums[j] + nums[k];
	                if(sum < 0) j++;
	                else if(sum > 0) k--;
	                else{
	                    List<Integer> trip = new ArrayList<>();
	                    trip.add(nums[i]);trip.add(nums[j]);trip.add(nums[k]);
	                    ans.add(trip);
	                    j++;k--;
	                    //avoid duplicate nums[j] after getting one triplet
	                    while(j<k && nums[j] ==nums[j-1]) j++;
	                }
	               
	            }
	        }
	        return ans;
	    }
}
