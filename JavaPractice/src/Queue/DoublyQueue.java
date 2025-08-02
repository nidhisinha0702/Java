package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DoublyQueue {

	public static void main(String[] args) {
		Deque<Integer> dq = new ArrayDeque<Integer>();
		dq.addLast(1);
		dq.addLast(2);
		dq.addLast(3);
		
		dq.addFirst(4);
		
		System.out.println(dq.getFirst() +" "+dq.getLast());
	}

}
