package TwoPointer;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {0,0,1,1,1,2,2,3,3,4};
		System.out.println("Number of unique elements are : "+removeDuplicates(nums));

	}
	
	public static int removeDuplicates(int[] nums) {
        int first = 0, second = 1;
        int n = nums.length;
        int res = 1;
        while(second<n){
            //duplicate skip
            if(nums[second] == nums[second-1]){
                second++;
                continue;
            }
            //unique add
            nums[first+1] = nums[second];
            res++;
            second++;
            first++;
        }return res;
    }

}
