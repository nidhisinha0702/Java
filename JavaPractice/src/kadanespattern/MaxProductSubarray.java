package kadanespattern;

public class MaxProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,-2,4};
		System.out.println("Maximum producet sub array is : "+maxProduct(nums));

	}
	public static int maxProduct(int[] nums) {
        int bestMin = nums[0];
        int bestMax = nums[0];
        int ans = nums[0];
        int n = nums.length;
        for(int i=1;i<n;i++){
            int v1 = nums[i];
            int v2 = bestMin * nums[i];
            int v3 = bestMax * nums[i];
            bestMin = Math.min(v1, Math.min(v2,v3));
            bestMax = Math.max(v1, Math.max(v2,v3));
            ans = Math.max(ans, Math.max(bestMin, bestMax));
        }return ans;
	}

}
