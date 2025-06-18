package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromPartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		List<String> partitions = new ArrayList<>();
		List<List<String>> ans = new ArrayList<>();
		getAllParts(s, partitions, ans);
		System.out.println(ans);
	}

	static void getAllParts(String s, List<String> partitions, List<List<String>> ans) {
		
		//bc
		if(s.length() == 0) {
			ans.add(new ArrayList<>(partitions));
			return;
		}
		
		for(int i=0;i<s.length();i++) {
			String part = s.substring(0, i+1);
			if(isPalindrome(part)) {
				partitions.add(part);
				getAllParts(s.substring(i+1), partitions, ans);
				//backtrack
				partitions.remove(partitions.size() - 1);
			}
		}
	}
	
	static boolean isPalindrome(String part) {
		StringBuilder sb = new StringBuilder(part);
		sb = sb.reverse();
		return part.equals(sb.toString());
	}
}
