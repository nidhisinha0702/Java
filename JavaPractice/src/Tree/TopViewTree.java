package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopViewTree {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);

		System.out.println("Top view are : ");
		topView(root);

	}
	static void topView(Node root) {
		Queue<Pair> q = new LinkedList<>();
		Map<Integer, Node> mpp = new HashMap<>();
		q.offer(new Pair(0,root));
		
		while(!q.isEmpty()) {
			Node curr = q.peek().node;
			int dist = q.peek().dis;
			q.poll();
			mpp.putIfAbsent(dist, curr);
			
			if(curr.left != null) q.offer(new Pair(dist-1,curr.left));
			if(curr.right != null) q.offer(new Pair(dist+1,curr.right));
		}
		
		for(Map.Entry<Integer, Node> en:mpp.entrySet()) {
			System.out.print(en.getValue().data +" ");
		}
		System.out.println();
	}
	static class Pair{
		int dis;
		Node node;
		Pair(int dis, Node node){
			this.dis=dis;
			this.node = node;
		}
	}
}


