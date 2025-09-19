package Tree;

import java.util.LinkedList;
import java.util.Queue;

//O(n)
public class Traversal {

	public static void main(String[] args) {
		int arr[] = {1,2,-1,-1,3,-1,-1,4,-1,-1,5,-1,-1};
	}
	
	static void preOrder(Node root) {
		if(root == null) return;
		
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	static void inOrder(Node root) {
		if(root == null) return;
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	static void postOrder(Node root) {
		if(root == null) return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}

	static void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			System.out.print(curr.data+" ");
			if(curr.left != null) q.offer(curr.left);
			if(curr.right != null) q.offer(curr.right);
		}
	}
	
	static void levelOrderLevelwise(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			if(curr == null) {
				//we hit null means new line
				if(!q.isEmpty()) {
					System.out.println();
					q.offer(null);
					continue;
				}else break;//q is empty
			}
			
			System.out.print(curr.data+" ");
			if(curr.left != null) q.offer(curr.left);
			if(curr.right != null) q.offer(curr.right);
		}
	}
}
