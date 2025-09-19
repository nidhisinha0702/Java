package Stack;

import java.util.Stack;

public class MinimumReversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "]]]]][][][][[[[[";
		System.out.println("minimum operation : "+minReversalII(s));

	}
	//O(n) O(n)
	private static int minReversal(String s) {
		if(s.length() % 2 == 1)
			return -1;
		//]]][[[ -> ][][][ -> [[][]]--->(3 + 1)/2-->(number of open/close + 1)/2
		//]]]]][[[[[ -> ]]][][][[[ -> ][][][][][ -> [[][][][]] -> (5 + 1) / 2
		//one swap helps to balance two pairs
		Stack<Character> st = new Stack<>();
		char ch[] = s.toCharArray();
		for(char c:ch) {
			if(c == '[') {
				st.push(c);
			}else if(!st.isEmpty()) {
				st.pop();
			}
		}
		
		return (st.size() + 1)/2;
	}
	//O(n) O(1)
	private static int minReversalII(String s) {
		if(s.length() % 2 == 1)
			return -1;
		//]]][[[ -> ][][][ -> [[][]]--->(3 + 1)/2-->(number of open/close + 1)/2
		//]]]]][[[[[ -> ]]][][][[[ -> ][][][][][ -> [[][][][]] -> (5 + 1) / 2
		//one swap helps to balance two pairs
		int size = 0;
		char ch[] = s.toCharArray();
		for(char c:ch) {
			if(c == '[') {
				size++;
			}else if(size > 0) {
				size--;
			}
		}
		
		return (size + 1)/2;
	}

}
