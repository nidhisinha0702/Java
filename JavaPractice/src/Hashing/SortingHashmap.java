package Hashing;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

}
