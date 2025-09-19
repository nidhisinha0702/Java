package LinkedList;
import java.util.List;

public class MergeKLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 Node mergeKLists(List<Node> arr) {
	        // Add your code here.
	        if(arr.size() == 0) return null;
	        
	        return mergeListsRecur(0, arr.size()-1,arr);
	    }
	    
	    Node mergeListsRecur(int i, int j, List<Node> arr){
	        
	        //if single list
	        if(i == j) return arr.get(i);
	        
	        int mid = i + (j - i)/2;
	        
	        Node head1 = mergeListsRecur(i, mid, arr);
	        Node head2 = mergeListsRecur(mid + 1, j, arr);
	        
	        Node head = mergeTwo(head1, head2);
	        
	        return head;
	    }
	    
	    Node mergeTwo(Node head1, Node head2){
	        if(head1 == null || head2 == null)
	            return head1 == null ? head2: head1;
	            
	        if(head1.data <= head2.data){
	            head1.next = mergeTwo(head1.next, head2);
	            return head1;
	        }else{
	            head2.next = mergeTwo(head1, head2.next);
	            return head2;
	        }
	    }
}
