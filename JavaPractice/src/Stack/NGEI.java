package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NGEI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums1[] = {4,1,2}, nums2[] = {1,3,4,2};
		System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));

	}
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mpp = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        //find the next greater element for nums2
        for(int i=nums2.length-1;i>=0;i--){
        	//pop smaller elements from stack
            while(!st.isEmpty() && st.peek() <= nums2[i])
             st.pop();
            //if stack is empty / last element -1
            if(st.isEmpty())
                mpp.put(nums2[i], -1);//store in map to track it back for nums1
            else
                mpp.put(nums2[i], st.peek());
            st.push(nums2[i]);
        }

        int ans[] = new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            ans[i] = mpp.get(nums1[i]);
        }

        return ans;
    }
}
