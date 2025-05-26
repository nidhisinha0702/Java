package Collections;

import java.util.Iterator;
import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		//Stack
		Stack<String> stack = new Stack<>();
		stack.push("Geeks");
		stack.push("For");
		stack.push("Geeks");
		stack.push("Geeks");
		
		Iterator<String> itr = stack.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next()+" ");
		}
		
		System.out.println();
		
		stack.pop();
		
		itr = stack.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next()+" ");
		}

	}

}
