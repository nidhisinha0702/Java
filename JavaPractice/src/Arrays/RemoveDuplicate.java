package Arrays;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,0,1,1,1,1,2,3,3};
		System.out.println("The length of unique elements after two duplicates is : "+removeDuplicates(nums));

	}
	 public static int removeDuplicates(int[] nums) {
	        int k = 2;
	        for(int i=2;i<nums.length;i++){
	            if(nums[i] != nums[k-2]){
	                nums[k] = nums[i];
	                k++;
	            }
	        }return k;
	    }
}
