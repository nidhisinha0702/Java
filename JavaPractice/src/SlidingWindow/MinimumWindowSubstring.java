package SlidingWindow;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ADOBECODEBANC", t = "ABC";
		System.out.println("Minimum window substring is : "+minWindow(s, t));

	}
	public static String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        int low = 0, high = 0, start = -1;
        int minLen = Integer.MAX_VALUE;
        int have[] = new int[256];
        int need[] = new int[256];
        //freq map for char in t
        for(char c:t.toCharArray()){
            need[c]++;
        }

        while(high < s.length()){
            have[s.charAt(high)]++;
            while(valid(have, need)){
                int len = high - low + 1;
                if(minLen > len){
                    minLen = len;
                    start = low;
                }
                have[s.charAt(low)]--;
                low++;
            }
            high++;
        }
        
        return minLen == Integer.MAX_VALUE? "":s.substring(start, start+minLen);
    }
    static boolean valid(int have[], int need[]){
        for(int i=0;i<256;i++){
            if(have[i] < need[i])
                return false;
        }return true;
    }
}
