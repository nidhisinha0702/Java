package String;

import java.util.HashMap;
import java.util.Map;

public class CountCharacterInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abccc";
		String s2 = "bbcd";
		
		Map<Character, Integer> diffMap = getDifferenceCharCounts(s1, s2);
		System.out.println(diffMap);

	}

	static Map<Character, Integer> getDifferenceCharCounts(String s1, String s2){
		Map<Character, Integer> count = new HashMap<>();
		
		//count characters in s1 (add)
		for(char c: s1.toCharArray()) {
			count.put(c,  count.getOrDefault(c,  0)+1);
		}
		
		//count characters in s2 (subtract)
		for(char c:s2.toCharArray()) {
			count.put(c,  count.getOrDefault(c, 0)-1);
		}
		
		//remove zero counts and make all values positive
		Map<Character, Integer> result = new HashMap<>();
		for(Map.Entry<Character, Integer> entry:count.entrySet()) {
			int diff = Math.abs(entry.getValue());
			if(diff > 0) {
				result.put(entry.getKey(), diff);
			}
		}
		
		return result;
	}
}
