package Collections;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class QDemo {

	public static void main(String[] args) {
		// Q
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		pQueue.add(10);
		pQueue.add(20);
		pQueue.add(15);
		
		deque.add(10);
		deque.add(20);
		deque.add(30);
		deque.add(40);
		deque.add(50);
		
		System.out.println(pQueue.peek());
		System.out.println(deque);
		
		System.out.println(pQueue.poll());
		
		System.out.println(pQueue.peek());
		
		deque.clear();
		
		deque.addFirst(564);
		deque.addFirst(291);
		
		deque.addLast(24);
		deque.addLast(14);
		
		System.out.println(deque); 
		
		
		

	}

}
