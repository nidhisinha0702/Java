package Stack;
import java.util.Arrays;
import java.util.Stack;
public class NGEII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {3,6,5,4,2};
		System.out.println(Arrays.toString(nextGreaterElements(nums)));

	}
	//O(2n)
	 public static int[] nextGreaterElements(int[] nums) {
	        int n = nums.length;
	        int[] ans = new int[n];
	        Stack<Integer> s = new Stack<>();

	        for(int i=2*n-1;i>=0;i--){
	            //pop smaller elements
	            while(!s.isEmpty() && nums[s.peek()] <= nums[i % n])
	            s.pop();

	            ans[i%n] = s.isEmpty() ? -1 : nums[s.peek()];

	            s.push(i%n);
	        }
	        return ans;
	    }
}
