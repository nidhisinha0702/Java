package Collections;

import java.util.LinkedList;

public class ReverseLinkedList {

	public static void main(String[] args) {
		//WAP to reverse a linkedlist in java
		LinkedList<Integer> ll = new LinkedList<>();
		
		ll.add(1);
		ll.add(2);
		ll.add(3);
		
		System.out.println(ll);
		
		LinkedList<Integer> list = new LinkedList<>();
		ll.descendingIterator().forEachRemaining(list::add);
		
		System.out.println(list);

	}

}
