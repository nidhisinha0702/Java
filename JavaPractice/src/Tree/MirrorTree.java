package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {

	public static void main(String[] args) {
		

	}
	void mirror(Node node) {
        // code here
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            //swap the pointers
            Node temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            
            if(curr.left != null) q.offer(curr.left);
            if(curr.right != null) q.offer(curr.right);
            
        }
    }
}
