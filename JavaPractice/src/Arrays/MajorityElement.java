package Arrays;

import java.util.Arrays;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,2,1,1};
		//we are sure that the majority element will exist sure shot
		System.out.println("The majority element that appears more than n/2 times in the array is : "+mooresVotingAlgo(arr));

	}
	//TC->O(n^2)
	public static int majorityElement(int[] nums) {
		int n = nums.length;
        for(int val:nums){
            int freq = 0;
            //iterate over the array
            for(int el:nums){
                if(el == val){
                    freq++;
                }
            }if(freq > n/2)
            return val;
        }return -1;
    }
	//TC->O(nlogn)
	public static int majorityElementII(int[] nums) {
        int n = nums.length;
        //sort
        Arrays.sort(nums);
        //freq count
        int freq = 1, ans = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i] == nums[i-1]){
                freq++;
            }else{
                freq = 1;
                ans = nums[i];
            }
            //>n/2
            if(freq > n/2) return ans;
        }
        return ans;
    }
	//O(n)
	 public static int mooresVotingAlgo(int[] nums) {
	        int n = nums.length;
	       
	        int freq = 0, ans = 0;
	        for(int i=0;i<n;i++){
	            if(freq == 0){
	                ans = nums[i];
	            }
	            if(ans == nums[i]) freq++;
	            else freq--;
	        }
	        return ans;
	   }
	 //if the question states that majority element may not exist then we need to perform one extra step after moore's voting algorithms
	 //to check if the ans if the majority element or not
	 //int cnt;//iterate over the array if(ans == nums[i]) cnt++; if(cnt >n/2) return ans or -1
}
