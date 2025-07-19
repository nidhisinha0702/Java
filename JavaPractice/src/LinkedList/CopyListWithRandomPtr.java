package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPtr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeR head = new NodeR(7);
		head.random = null;
        head.next = new NodeR(13);
        head.next.random = head;
        head.next.next = new NodeR(11);
        head.next.next.random = head.next.next.next;
        head.next.next.next = new NodeR(10);
        head.next.next.next.random = head.next.next;
        head.next.next.next.next = new NodeR(1);
        head.next.next.next.next.random = head;
        
        System.out.println(copyRandomList(head).val);

	}
	public static NodeR copyRandomList(NodeR head) {
        if(head == null)
        return null;
        //to track pointer for random pointer
        Map<NodeR,NodeR> mpp = new HashMap<>();
        //step 1 create a simple copy LL and ignore random pointers
        NodeR newHead = new NodeR(head.val);
        NodeR oldTemp = head.next, newTemp = newHead;
        mpp.put(head, newHead);

        while(oldTemp != null){
            NodeR copyNodeR = new NodeR(oldTemp.val);
            mpp.put(oldTemp, copyNodeR);
            newTemp.next = copyNodeR;

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        oldTemp = head; newTemp = newHead;
        //step2 point all the random pointer in copy LL
        while(oldTemp != null){
            newTemp.random = mpp.get(oldTemp.random);
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        return newHead;
    }
}
class NodeR{
	int val;
	NodeR next, random;
	NodeR(int val){
		this.val = val;
		next = random = null;
	}
}
