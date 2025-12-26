package String;

public class CheckAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "geeks";
		String s2 = "kseeg";
		
		if(areAnagrams(s1, s2))
			System.out.println("true");
		else 
			System.out.println("false");

	}
	
	public static boolean areAnagrams(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		
		//for lowercase
		int[] freq = new int[26];
		
		//count frequency of each character in s1
		for(int i=0;i<s1.length();i++)
			freq[s1.charAt(i) - 'a']++;
		
		//subtract frequency using characters from s2
		for(int i=0;i<s2.length();i++)
			freq[s2.charAt(i) - 'a']--;
		
		//check if all frequencies are zero
		for(int count : freq) {
			if(count != 0)
				return false;
		}
		return true;
	}

}
