package LinkedList;

public class RemoveCycleLL {

	public static void main(String[] args) {
		Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head.next; // Creates a cycle
        
        removeLoop(head);
        
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }System.out.println("null");

	}
	public static void removeLoop(Node head) {
        // if there in no ll or single node
        if(head == null || head.next == null)
            return;
        //detect cycle    
        Node slow = head, fast = head;
        boolean isCycle = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }
        //no cycle detected
        if(!isCycle){
            return;
        }
        
        //find start of the cycle
        slow = head;
        
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        //break the cycle
        Node cycleStart = slow;
        Node temp = cycleStart;
        while(temp.next != cycleStart){
            temp = temp.next;
        }
        temp.next = null;
    }
}
