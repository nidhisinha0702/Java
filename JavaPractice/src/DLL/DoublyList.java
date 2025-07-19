package DLL;

class Node {
	int data;
	Node next, prev;
	Node(int val){
		data = val;
		next = prev = null;
	}
}

public class DoublyList{
	Node head, tail;
	
	DoublyList(){
		head = tail = null;
	}
	
	public void push_front(int val) {
		Node newNode = new Node(val);
		if(head == null) {
			head = tail = newNode; 
		}else {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
	}
	
	public void push_back(int val) {
		Node newNode = new Node(val);
		if(head == null) {
			head = tail = newNode; 
		}else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void pop_front() {
		if(head == null)
			return;
		Node temp = head;
		head = head.next;
		if(head!= null)
			head.prev = null;
		temp.next = null;
	}
	
	public void pop_back() {
		if(head == null)
			return;
		Node temp = tail;
		tail = tail.prev;
		if(tail != null)
		tail.next = null;
		temp.prev = null;
	}
	
	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+"<=>");
			temp = temp.next;
		}System.out.println("null");
	}
	
	public static void main(String args[]) {
		DoublyList dll = new DoublyList();
		dll.push_back(1);
		dll.push_back(2);
		dll.push_back(3);
		dll.print();
		dll.pop_front();
		dll.print();
		dll.pop_back();
		dll.print();
	}
}
