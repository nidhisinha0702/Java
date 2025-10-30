package Hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,6,1,9,4,5,3};
		System.out.println(longestConsecutive(arr));
		}
	
	public static int longestConsecutive(int[] arr) {
		Set<Integer> st = new HashSet<>();
		int res = 0;
		
		//hash all the array elements
		for(int val:arr) {
			st.add(val);
		}
		
		//check each possible sequence from the start then update optimal length
		for(int val : arr) {
			//if curr element is the starting element of a sequence
			if(st.contains(val) && !st.contains(val-1)) {
				//then check for the next element in the sequence
				int cur = val, cnt = 0;
				while(st.contains(cur)) {
					//remove this number to avoid recomputation
					st.remove(cur);
					cur++;
					cnt++;
				}
				//update optimal length
				res = Math.max(res,  cnt);
			}
		}return res;
	}

}
