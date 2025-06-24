package String;

public class CheckPalindrome {

	public static void main(String[] args) {
		// WAP to check if the string is palindrome
		String s = "madam";
		System.out.println(" the string is palindrome : "+checkPalindrome(s));
		//System.out.println("stribg builder : "+isPalindrome(s));

	}
	
	private static boolean checkPalindrome(String input) {
		if(input == null || input.length() == 0) return true;
		int length = input.length();
		int i = 0;
		while(i<length/2) {
			if(input.charAt(i) != input.charAt(length - i - 1)) {
				return false;
			}i++;
		}return true;
	}
	
	static boolean isPalindrome(String part) {
		StringBuilder sb = new StringBuilder(part);
		sb = sb.reverse();
		System.out.println(sb);
		System.out.println("true or false "+(part.equalsIgnoreCase(sb.toString())));
		return part.equals(sb);
	}

}
