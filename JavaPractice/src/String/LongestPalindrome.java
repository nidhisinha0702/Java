package String;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "forgeeksskeegfor";
		System.out.println(longestPalindrome(s));

	}
	public static String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        //center expansion O(n^2)
        String LPS = "";
        int n = s.length();
        for(int i=1;i<n;i++){
            //odd length
            int low = i, high = i;
            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;
                //boundary
                if(low == -1 || high == n)
                break;
            }

            String palindrome = s.substring(low + 1, high);
            if(palindrome.length() > LPS.length()){
                LPS = palindrome;
            }

            //even length
            low = i-1; high = i;
            while(s.charAt(low) == s.charAt(high)){
                low--;
                high++;
                //boundary
                if(low == -1 || high == n)
                break;
            }

            palindrome = s.substring(low + 1, high);
            if(palindrome.length() > LPS.length()){
                LPS = palindrome;
            }
        }return LPS;
    }
}
