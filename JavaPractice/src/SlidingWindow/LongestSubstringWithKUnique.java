package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabacbebebe";
		int k = 3;
		System.out.println("Longest substring with k unique length is : "+longestKSubstr(s, k));
	}
	public static int longestKSubstr(String s, int k) {
        // code here
        Map<Character, Integer> mpp = new HashMap<>();
        int n = s.length();
        int low = 0, high = 0, res = -1;
        
        while(high < n){
            mpp.put(s.charAt(high), mpp.getOrDefault(s.charAt(high),0)+1);
            //shrink window if more than k unique
            while(mpp.size() > k){
                char leftChar = s.charAt(low);
                mpp.put(leftChar, mpp.get(leftChar)-1);
                if(mpp.get(leftChar) == 0)
                    mpp.remove(leftChar);
                low++;
            }
            //if exactly k uniques
            if(mpp.size() == k){
                int len = high - low + 1;
                res = Math.max(res, len);
            }high++;
        }return res;
    }
}
