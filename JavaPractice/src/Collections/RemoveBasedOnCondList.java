package Collections;

import java.util.ArrayList;
import java.util.List;

public class RemoveBasedOnCondList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<>();
		names.add("Alice");
		names.add("Bob");
		names.add("Charlie");
		names.add("David");
		names.add("Eve");
		
		System.out.println("Original Names: "+names);
		
		names.removeIf(name->name.startsWith("C"));
		
		System.out.println("Names after removal: "+names);
	}

}
