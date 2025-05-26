package String;

import java.util.HashMap;
import java.util.Map;

public class CharCount {

	public static void main(String[] args) {
		// WAP to get distinct characters and their count in a string
		
		String str1 = "abcdABCDabcd";
		
		char[] chars = str1.toCharArray();
		
		Map<Character, Integer> charsCount = new HashMap<>();
		
		for(char c:chars) {
			charsCount.put(c, charsCount.getOrDefault(c, 0)+1);
		}
		
		System.out.println(charsCount);

	}

}
