package String;

public class PermutationInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "ab", s2 = "eidbaooo";
		System.out.println(checkInclusion(s1, s2));
	}
	 public static boolean checkInclusion(String s1, String s2) {
	        //edge case
	        if(s1.length() > s2.length())
	            return false;
	        int freq[] = new int[26];
			int windFreq[] = new int[26];
	        //initially add the {freq, count} to the hash-array
			for(int i=0;i<s1.length();i++) {
				freq[s1.charAt(i) - 'a']++;
	            windFreq[s2.charAt(i) - 'a']++;
			}

	        //slide the window of s1.length size
	        for(int i=0;i<s2.length() - s1.length();i++){
	            //check if the count matches
	            if(isFreqSame(freq, windFreq))
	                return true;
	            
	            //add new character to the window
	            windFreq[s2.charAt(i + s1.length()) - 'a']++;
	            //remove the old character from the window
	            windFreq[s2.charAt(i) - 'a']--;
	        }
	        //check the last window
	        return isFreqSame(freq, windFreq);
	    }

	    static boolean isFreqSame(int freq1[], int freq2[]){
	        for(int i=0;i<26;i++){
	            if(freq1[i] != freq2[i]){
	                return false;
	            }
	        }return true;
	    }
}
