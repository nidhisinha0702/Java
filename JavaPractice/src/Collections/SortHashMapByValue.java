package Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SortHashMapByValue {

	public static void main(String[] args) {
		// WAP that sorts HashMap by value
		Map<String, Integer> scores = new HashMap<>();
		scores.put("David", 95);
		scores.put("Jena", 80);
		scores.put("Elena", 97);
		scores.put("Caroline", 78);
		scores.put("Damon", 65);
		
		System.out.println("Before sorting : "+scores);
		
		scores = sortByValue(scores);
		
		System.out.println("After sorting : "+scores);

	}
	
	private static Map<String, Integer> sortByValue(Map<String, Integer> scores){
		//to store the result 
		Map<String, Integer> sortedByValue = new LinkedHashMap<>();
		
		//get the entry set
		Set<Entry<String, Integer>> entrySet = scores.entrySet();
		System.out.println("Entry Set : "+entrySet);
		
		//create a list since the set is unordered
		List<Entry<String, Integer>> entryList = new ArrayList<>(entrySet);
		System.out.println("Entry List before : "+entryList);
		
		//sort the list by value
		entryList.sort((x,y) -> x.getValue().compareTo(y.getValue()));
		System.out.println("Entry List After : "+entryList);
		
		//populate the new hashMap
		for(Entry<String, Integer> e:entryList)
			sortedByValue.put(e.getKey(), e.getValue());
		
		return sortedByValue;
	}

}
