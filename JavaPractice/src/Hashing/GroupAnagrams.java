package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String strs[] = {"eat","tea","tan","ate","nat","bat"};
		 System.out.println(groupAnagrams(strs));
	}
	public static List<List<String>> groupAnagrams(String[] strs) {

        // Create a map to group the anagrams, where the key is the sorted string, and the value is a list of original strings.
        //{"aet":["eat","tea","ate"], "ant":["nat","tan"],"abt":["bat"]}
        Map<String, List<String>> anagramsMap = new HashMap<>();

        //iterate over the string array
        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);//O(nlogn)

            //create a new string from sorted char array
            String sortedStr = String.valueOf(charArray);

            anagramsMap.computeIfAbsent(sortedStr, k-> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagramsMap.values());

    }
}
