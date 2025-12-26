package LinkedList;

public class ReverseLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List ll = new List();
		ll.push_front(3);
		ll.push_front(2);
		ll.push_front(1);
		ll.printLL();

	}
	
	static Node reverse(Node head) {
		Node prev = null, next = null;
		Node curr = head;
		
		while(curr!= null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	static Node reverseListRecursive(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node newHead = reverseListRecursive(head.next);
		
		Node front = head.next;
		front.next = head;
		head.next = null;
		
		return newHead;
	}

}
