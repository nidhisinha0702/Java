package String;

public class CheckPalindrome {

	public static void main(String[] args) {
		// WAP to check if the string is palindrome
		String s = "madam";
		System.out.println(" the string is palindrome : "+checkPalindrome(s));
		

	}
	
	private static boolean checkPalindrome(String input) {
		boolean result = true;
		int length = input.length();
		int i = 0;
		while(i<length/2) {
			if(input.charAt(i) != input.charAt(length - 1 -1)) {
				result = false;
				break;
			}
		}return result;
	}

}
