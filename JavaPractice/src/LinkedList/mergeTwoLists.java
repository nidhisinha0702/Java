package LinkedList;

public class mergeTwoLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(6);
        
        System.out.println(mergeLists(head1, head2).data);

	}
	//O(n+m)
    public static Node mergeLists(Node head1, Node head2) {
        //bc
        if(head1 == null || head2 == null){
            return head1 == null ? head2 : head1;
        }

        //case1
        if(head1.data <= head2.data){
            head1.next = mergeLists(head1.next, head2);
            return head1;
        }else{
            head2.next = mergeLists(head1, head2.next);
            return head2;
        }
    }
}
