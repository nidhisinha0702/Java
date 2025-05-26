package Collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

	public static void main(String[] args) {
		// WAP to demo Map
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		
		hm.put(1, "Geeks");
		hm.put(2, "For");
		hm.put(3, "Geeks");
		
		System.out.println("Value for 1 is "+hm.get(1));
		
		for(Map.Entry<Integer, String> e:hm.entrySet())
			System.out.println(e.getKey() +" "+e.getValue());

	}

}
