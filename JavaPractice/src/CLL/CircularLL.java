package CLL;

public class CircularLL {

	Node head, tail;
	
	CircularLL(){
		head = tail = null;
	}
	
	public void inserAtHead(int val) {
		Node newNode = new Node(val);
		
		if(tail == null) {
			head = tail = newNode;
			tail.next = head;
		}else {
			newNode.next = head;
			head = newNode;
			tail.next = newNode;
		}
	}
	
	public void inserAtTail(int val) {
		Node newNode = new Node(val);
		
		if(tail == null) {
			head = tail = newNode;
			tail.next = head;
		}else {
			newNode.next = head;
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	public void deleteAtHead() {
		if(tail == null) {
			return;
		}else if(head == tail)
			head = tail = null;
		else {
			Node temp = head;
			head = head.next;
			tail.next = head;
			temp.next = null;
		}
	}
	
	public void deleteAtTail() {
		if(head == null) {
			return;
		}else if(head == tail)
			head = tail = null;
		else {
			Node temp = tail;
			Node prev = head;
			while(prev.next != tail) {
				prev = prev.next;
			}
			tail = prev;
			tail.next = head;
			temp.next = null;
		}
	}
	
	public void print() {
		if(tail == null) {
			return;
		}
		System.out.print(head.data+"->");
		Node temp = head.next;
		while(temp != head) {
			System.out.print(temp.data+"->");
			temp = temp.next;
		}System.out.println(temp.data+"");
	}
	
	public static void main(String[] args) {
		CircularLL cll = new CircularLL();
		cll.inserAtHead(3);
		cll.inserAtHead(2);
		cll.inserAtHead(1);
		
		cll.print();
		
		cll.deleteAtTail();
		cll.print();
		
		cll.deleteAtTail();
		cll.print();
		
		cll.deleteAtTail();
		cll.print();
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
