package kadanespattern;

public class MinSumCircularSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,-2,3,-2};
		System.out.println("Maximum subarray circular sum : "+maxSubarraySumCircular(nums));
	}
	
	public static int maxSubarraySumCircular(int[] nums) {
        int minBest = nums[0];
        int maxBest = nums[0];
        int minAns = nums[0];
        int maxAns = nums[0];
        int n = nums.length;

        for(int i=1;i<n;i++){
            int v1 = nums[i];
            int v2 = minBest + nums[i];
            minBest = Math.min(v1, v2);
            minAns = Math.min(minAns, minBest);
        }

        for(int i=1;i<n;i++){
            int v1 = nums[i];
            int v2 = maxBest + nums[i];
            maxBest = Math.max(v1, v2);
            maxAns = Math.max(maxAns, maxBest);
        }

        int totSum = 0;
        for(int x:nums){
            totSum += x;
        }

         if(totSum == minAns){
             return maxAns;
         }

        int circular = totSum - minAns;
        return Math.max(maxAns, circular);
    }

}
