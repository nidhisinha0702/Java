package SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestSubstringWithoutDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcabcbb";
		System.out.println("Longest substring without repeating character is : "+lengthOfLongestSubstring(s));
	}
	public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();
        int low = 0, high = 0, res = 0;

        while(high < n){
            map.put(s.charAt(high), map.getOrDefault(s.charAt(high), 0)+1);
            int k = high - low + 1;
            while(map.size() < k){
                char leftChar = s.charAt(low);
                map.put(leftChar, map.get(leftChar)-1);
                if(map.get(leftChar) == 0)
                    map.remove(leftChar);
                low++;
                k = high - low + 1;
            }
            res = Math.max(res, high - low + 1);
            high++;
        }return res;
    }
	
	
}
