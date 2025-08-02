package Hashing;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortHashMapByValue {

	public static void main(String[] args) {
		 HashMap<String, Integer> hm = new HashMap<String, Integer>();

	        // enter data into hashmap
	        hm.put("Math", 98);
	        hm.put("Data Structure", 85);
	        hm.put("Database", 91);
	        hm.put("Java", 95);
	        hm.put("Operating System", 79);
	        hm.put("Networking", 80);
	        Map<String, Integer> hm1 = sortByValueUsingStream(hm);

	        // print the sorted hashmap
	        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
	            System.out.println(en.getKey() + ": " + en.getValue());
	        }

	}

	private static Map<String, Integer> sortByValue(HashMap<String, Integer> hm) {
		
		//create a list from elements of hashmap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
		
		//sort the list using lamda expression
		Collections.sort(list, (a,b)->a.getValue().compareTo(b.getValue()));
		
		//put data from sorted list to hashmap
		Map<String, Integer> mpp = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> aa: list) {
			mpp.put(aa.getKey(), aa.getValue());
		}
		
		return mpp;
	}

	private static Map<String, Integer> sortByValueUsingStream(HashMap<String, Integer> hm) {
		HashMap<String, Integer> temp = hm.entrySet().stream().sorted((a,b)->a.getValue().compareTo(b.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldvalue,newvalue) -> oldvalue, LinkedHashMap::new));
				
				return temp;
	}
}
