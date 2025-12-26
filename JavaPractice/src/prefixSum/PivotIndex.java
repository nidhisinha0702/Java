package prefixSum;

public class PivotIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,7,3,6,5,6};
		System.out.println("The pivot index where the leftsum and rightsum are equal is : "+pivotIndex(nums));

	}
	public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int leftSum = 0;
        int totSum = 0;
        for(int i=0;i<n;i++){
            totSum += nums[i];
        }

        for(int i=0;i<n;i++){
            int rightSum = totSum - leftSum - nums[i];

            if(leftSum == rightSum)
                return i;
            
            leftSum += nums[i];
        }return -1;
    }
}
