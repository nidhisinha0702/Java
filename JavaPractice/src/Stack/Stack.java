package Stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {

	List<Integer> list = new ArrayList<>();
	
	public void push(int val) {//O(1)
		list.add(val);
	}
	
	public void pop() {//O(1)
		list.remove(list.size() - 1);
	}
	
	public int top() {
		return list.get(list.size() - 1);
	}
	
	public boolean empty() {
		return list.size() == 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		
		while(!s.empty()) {
			System.out.print(s.top()+" ");
			s.pop();
		}System.out.println();
	}

}
