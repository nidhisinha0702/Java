package String;

public class CheckVowel {

	public static void main(String[] args) {
		// write a program (WAP) to check if a vowel is present in a string or not
		System.out.println(stringContainsVowels("Hello"));//true
		System.out.println(stringContainsVowels("TV"));//false
	}
	
	private static boolean stringContainsVowels(String input) {
		return input.toLowerCase().matches(".*[aeiou].*");
	}

}
