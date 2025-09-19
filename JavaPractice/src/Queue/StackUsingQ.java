package Queue;

import java.util.LinkedList;
import java.util.Queue;
public class StackUsingQ {

	    Queue<Integer> q1, q2;
	    public StackUsingQ() {
	        q1 = new LinkedList<Integer>();
	        q2 = new LinkedList<Integer>();
	    }
	    //o(n)
	    public void push(int x) {
	    	//push all the elements from q1 to q2
	        while(!q1.isEmpty()){
	            q2.offer(q1.peek());
	            q1.poll();
	        }
	        //push new element to q1
	        q1.offer(x);
	        //push back all the elements from q2 to q1
	        while(!q2.isEmpty()){
	            q1.offer(q2.poll());
	        }
	    }
	    
	    public int pop() {
	        int ans = q1.poll();
	        return ans;
	    }
	    
	    public int top() {
	        return q1.peek();
	    }
	    
	    public boolean empty() {
	        return q1.isEmpty();
	    }

}
