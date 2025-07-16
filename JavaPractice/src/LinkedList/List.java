package LinkedList;

class Node {
	int data;
	Node next;
	Node(int val){
		data = val;
		next = null;
	}
}

public class List{
	Node head;
	Node tail;
	
	public List() {
		head = tail = null;
	}
	//O(1)
	void push_front(int val) {
		Node newNode = new Node(val);//dynamic object
		if(head == null) {
			head = tail = newNode;
			return;
		}else {
			newNode.next = head;
			head = newNode;
		}
	}
	//O(1)
	void push_back(int val) {
		Node newNode = new Node(val);
		
		if(head == null) {
			head = tail = newNode;
		}else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	//O(1)
	void pop_front() {
		if(head == null) {
			return;
		}
		Node temp = head;
		head = head.next;
		temp.next = null;
	}
	//O(n)
	void pop_back() {
		if(head == null)
			return;
		Node temp = head;
		while(temp.next != tail) {
			temp = temp.next;
		}
		//delete step
		temp.next = null;
		tail = temp;
	}
	//O(n)
	void insert(int val, int pos) {
		if(pos < 0) {
			System.out.println("invalid");
			return;
		}
		//insert at head
		if(pos == 0) {
			push_front(val);
			return;
		}
		
		Node temp = head;
		for(int i=0;i<pos-1;i++) {
			if(temp == null) {
				System.out.println("Invalid Position");
				return;
			}
			temp = temp.next;
		}
		Node newNode = new Node(val);
		newNode.next = temp.next;
		temp.next = newNode;
	}
	//O(n)
	int search(int key) {
		if(head == null)
			return -1;
		Node temp = head;
		int idx = 0;
		while(temp != null) {
			if(temp.data == key) {
				return idx;
			}temp = temp.next;
			idx++;
		}return -1;
	}
	//O(n)
	void printLL() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+"->");
			temp = temp.next;
		}System.out.print("null");
		System.out.println();
	}
	
	public static void main(String[] args) {
		List ll = new List();
		ll.push_front(3);
		ll.push_front(2);
		ll.push_front(1);
		ll.printLL();
		ll.insert(4, 1);
		ll.printLL();
		ll.insert(5, 3);
		ll.printLL();
		System.out.println(ll.search(4));
	}
}

