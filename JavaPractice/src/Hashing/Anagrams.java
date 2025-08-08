package Hashing;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "geeks", s2 = "kseeg";
		System.out.println(areAnagrams(s1, s2));

	}
	 public static boolean areAnagrams(String s1, String s2) {
	        // code here
	        if(s1.length() != s2.length()) return false;
	        
	        int[] freq = new int[26];
	        
	        for(int i=0;i<s1.length();i++){
	            freq[s1.charAt(i) - 'a']++;
	        }
	        
	        for(int j=0;j<s2.length();j++){
	            freq[s2.charAt(j) - 'a']--;
	        }
	        
	        for(int k=0;k<s1.length();k++){
	            if(freq[s1.charAt(k) - 'a'] != 0)
	                return false;
	        }
	        
	        return true;
	    }
}
