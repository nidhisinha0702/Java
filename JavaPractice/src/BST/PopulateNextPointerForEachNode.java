package BST;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateNextPointerForEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	 public Node connect(Node root) {
	        if(root == null || root.left == null)
	            return root;
	        
	        Queue<Node> q = new LinkedList<>();
	        q.add(root);
	        q.add(null);//mark the end of the level
	        Node prev = null;
	        while(q.size() > 0){
	            Node curr = q.peek();
	            q.poll();

	            if(curr == null){
	                if(q.size() == 0)
	                    break;
	                
	                q.add(null);
	            }else{
	                if(curr.left != null)
	                    q.add(curr.left);
	                if(curr.right != null)
	                    q.add(curr.right);
	                if(prev != null)
	                    prev.next = curr;
	            }
	            prev = curr;
	        }return root;
	    }

}
