package Hashing;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortingHashmap {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("abc", 2);
		map.put("def", 1);
		map.put("xyz", 3);
		map.put("ghi", 5);
		map.put("hmn", 4);
		map.put("uyn", 20);
		map.put("wmq", 61);
		map.put("pol", 80);
		
		System.out.println("---------Before Sorting-----");
		//call method to sort
		Map<String, Integer> hm = sortByValue(map);
		//Print the sorted hashMap
		for(Map.Entry<String, Integer> en: hm.entrySet()) {
			System.out.println(en.getKey() +" "+en.getValue());
		}
		
		String str = "tree";
		System.out.println(frequencySort(str));

	}
	
	private static Map<String, Integer> sortByValue(Map<String, Integer> hm){
		//create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
		
		//sort the list
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		
		//put data from sorted list to hashmap
		Map<String, Integer> mpp = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> aa: list) {
			mpp.put(aa.getKey(), aa.getValue());
		}
		
		return mpp;
	}

	private static String frequencySort(String s) {
		
		HashMap<Character, Integer> freq = new HashMap<>();
		//count the frequency of each character
		for(int i=0;i<s.length();i++) {
			freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);
		}
		
		//sort the map based on freq
		Map<Character, Integer> descSortFreq = freq.entrySet().stream().sorted((i1,i2)->i2.getValue().compareTo(i1.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldval,newval) -> oldval, LinkedHashMap::new));
		
		//fetch each character based on count and append to a string
		String ans = descSortFreq.entrySet().stream().flatMap(entry -> Stream.generate(()->entry.getKey()).limit(entry.getValue())).map(String::valueOf).collect(Collectors.joining());
		
		return ans;
	}
}
