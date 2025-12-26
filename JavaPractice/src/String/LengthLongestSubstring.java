package String;

import java.util.HashMap;
import java.util.Map;

public class LengthLongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "takeuforward";
		System.out.println(lengthOfLongestSubstring(s));

	}
	
	public static int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		//character index map
		Map<Character, Integer> charMap = new HashMap<>();
		int maxLength = 0;
		int l = 0, r = 0;
		
		while(r < s.length()) {
			if(charMap.containsKey(s.charAt(r))) {
				l = Math.max(charMap.get(s.charAt(r))+1, l);
			}
			charMap.put(s.charAt(r),r);
			maxLength = Math.max(maxLength, r-l+1);
			r++;
		}return maxLength;
	}

}
