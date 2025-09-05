package String;

public class PalindromeSubstrings {

	public static void main(String[] args) {
		String s = "bbabcbcab";
		System.out.println(countSubstrings(s));

	}

	 public static int countSubstrings(String s) {
	        if(s.isEmpty()) return 0;
	        int n = s.length();
	        if(n == 1) return 1;

	        int count = 0;

	        //center expansion
	        for(int i=0;i<n;i++){
	            //odd length
	            int low = i, high = i;
	            while(s.charAt(low) == s.charAt(high)){
	                low--;high++;count++;
	                //boundary
	                if(low == -1 || high == n)
	                break;
	            }

	            //even length
	            low = i-1; high = i;
	            while(low >= 0 && s.charAt(low) == s.charAt(high)){
	                low--;high++;count++;
	                //boundary
	                if(low == -1 || high == n)
	                break;
	            }
	        }return count;
	    }
}
