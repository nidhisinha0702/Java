package Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIDemo {

	public static void main(String[] args) {
		// WAP to demo stream filter and collect operations
		ArrayList<Integer> al = new ArrayList<>();
		
		al.add(2);
		al.add(6);
		al.add(9);
		al.add(4);
		al.add(20);
		
		System.out.println("Printing the collection :"+al);
		System.out.println();
		
		List<Integer> ls = al.stream().filter(i->i % 2 == 0).collect(Collectors.toList());
		
		System.out.println("Printing the list after stream operation : "+ls);

	}

}
