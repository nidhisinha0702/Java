package BitManipulation;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,4,1,2,1};
		System.out.println("the single number is : "+singleNumber(arr));

	}
	public static int singleNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int num:nums){
            xor ^= num;
        }return xor;
    }
}
