package Stack;

import java.util.Arrays;
import java.util.Stack;
public class PSE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {3,1,0,8,6};
		System.out.println(Arrays.toString(prevSmallerElement(arr)));

	}

	private static int[] prevSmallerElement(int arr[]) {
		int ans[] = new int[arr.length];
		Stack<Integer> s = new Stack<>();
		
		for(int i=0;i<arr.length;i++) {
			while(!s.isEmpty() && s.peek() >= arr[i])
				s.pop();
			ans[i] = s.isEmpty() ? -1:s.peek();
			s.push(arr[i]);
		}return ans;
	}
}
