package DLL;

public class ReverseKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		int k = 3;
		System.out.println(reverseKGroup(head,k).data);

	}
	public static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        //check if group exists
        int cnt = 0;
        while(cnt < k){
            if(temp == null)
            return head;
            temp = temp.next;
            cnt++;
        }

        //recursivel call for rest of LL
        Node prevNode = reverseKGroup(temp, k);
        
        //reverse the current group
        temp = head; cnt = 0;
        while(cnt < k){
            Node next = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = next;
            cnt++;
        }

        return prevNode;
    }
}
