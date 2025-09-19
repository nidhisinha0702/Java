package Stack;

import java.util.LinkedList;
import java.util.List;

public class StackLL {

	List<Integer> ll = new LinkedList<>();
	
	public void push(int val) {
		ll.addLast(val);
	}
	
	public int top() {
		return ll.getLast();
	}
	
	public void pop() {
		ll.removeLast();
	}
	
	public boolean empty() {
		return ll.size() == 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackLL s = new StackLL();
		s.push(10);
		s.push(20);
		s.push(30);
		
		while(!s.empty()) {
			System.out.print(s.top()+" ");
			s.pop();
		}System.out.println();
	}

}
