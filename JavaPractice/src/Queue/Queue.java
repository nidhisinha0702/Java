package Queue;

public class Queue {
	Node head, tail;
	
	Queue(){
		head = tail = null;
	}
	//O(1)
	public void push(int data) {//insert at the tail of LL
		Node newNode = new Node(data);
		if(empty()) {
			head = tail = newNode;
		}else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void pop() {//delete from the head of LL
		if(empty()) {
			System.out.println("LL is empty");
			return;
		}
		head = head.next;
	}
	
	public int front() {
		if(empty())
			return -1;
		return head.data;
	}
	
	boolean empty() {
		return head == null;
	}
	
	public static void main(String[] args) {
		Queue q = new Queue();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		
		q.pop();
		
		System.out.println(q.front());
	}

}
 class Node{
	 int data;
	 Node next;
	 
	 Node(int val){
		 data = val;
		 next = null;
	 }
 }