package Hashing;

import java.util.HashMap;

public class CountCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "GeeksForGeeks";
		HashMap<Character, Integer> charFreq = new HashMap<>();
		for(char c: str.toCharArray()) {
			charFreq.put(c, charFreq.getOrDefault(c, 0)+1);
		}
		
		charFreq.entrySet().stream().forEach(entry->System.out.println(entry.getKey()+" : "+entry.getValue()));
	}

}
