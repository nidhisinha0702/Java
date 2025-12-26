package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> result = groupAnagrams(input);
		System.out.println(result);

	}
	
	public static List<List<String>> groupAnagrams(String[] strs){
		Map<String, List<String>> map = new HashMap<>();
		
		for(String s:strs) {
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			map.computeIfAbsent(key, k-> new ArrayList<>()).add(s);
			
		}
		return new ArrayList<>(map.values());
	}
	
	public static List<List<String>> groupAnagramsStreams(String[] strs){
		
		return Arrays.stream(strs)
		        .collect(Collectors.groupingBy(
		                s -> {
		                    char[] chars = s.toCharArray();
		                    Arrays.sort(chars);
		                    return new String(chars);
		                }
		        ))//{"aet":["eat", "tea", "ate"],
		        //"ant": ["tan", "nat"],
		        //"abt": ["bat"]}
		        .values()
		        .stream()
		        .collect(Collectors.toList());

	}
}
