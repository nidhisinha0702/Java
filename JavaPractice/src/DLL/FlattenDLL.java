package DLL;

public class FlattenDLL {

	public static void main(String[] args) {
		//1<->2<->3<->4<->5
		//        |
		//        6<->7<->8
		//            |
		//            9<->10 convert to 
		//1<->2<->3<->6<->7<->9<->10<->8<->4<->5
		NodeF head = new NodeF(1);
		head.next = new NodeF(2);
		head.next.prev = head;
		head.next.next = new NodeF(3);
		head.next.next.prev = head.next;
		head.next.next.child = new NodeF(6);
		head.next.next.child.next = new NodeF(7);
		head.next.next.child.next.prev = head.next.next.child;
		head.next.next.child.next.child = new NodeF(9);
		head.next.next.child.next.child.next = new NodeF(10);
		head.next.next.child.next.child.next.prev = head.next.next.child.next.child;
		head.next.next.child.next.next = new NodeF(8);
		head.next.next.child.next.next.prev = head.next.next.child.next;
		head.next.next.next = new NodeF(4);
		head.next.next.next.prev = head.next.next;
		head.next.next.next.next = new NodeF(5);
		head.next.next.next.next.prev = head.next.next.next;
		
		System.out.println(flatten(head).val);

	}
	public static NodeF flatten(NodeF head) {
        if(head == null) return head;
        NodeF curr = head;
        while(curr != null){
            if(curr.child != null){
                //flatten the child nodes
                NodeF next = curr.next;//store the next node
                curr.next = flatten(curr.child);//connect the next to flatten's head
                curr.next.prev = curr;//connect the prev to curr
                curr.child = null;//disconnect the child
                //find tail
                while(curr.next != null)
                curr = curr.next;
                //attach tail with next ptr
                if(next != null){
                    curr.next = next;
                    next.prev = curr;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}

class NodeF{
	int val;
	NodeF next, prev, child;
	NodeF(int data){
		val = data;
		next = prev = child = null;
	}
}
