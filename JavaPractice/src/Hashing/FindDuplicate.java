package Hashing;

public class FindDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,3,4,2,2};
		System.out.println("duplicate number is : "+findDuplicate(nums));

	}
	//TC->O(n)
	public static int findDuplicate(int[] nums) {
		//similar as find the start of the cycle in linkedlist
        int slow = nums[0], fast = nums[0];
        do{
            slow = nums[slow];//+1
            fast = nums[nums[fast]];//+2
        }while(slow != fast);

        slow = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
