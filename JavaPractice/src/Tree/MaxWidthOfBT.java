package Tree;

import java.util.Deque;
import java.util.LinkedList;

public class MaxWidthOfBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int widthOfBinaryTree(TreeNode root) {
	        if(root == null) return 0;
	        Deque<Pair> q = new LinkedList<>();
	        q.add(new Pair(root, 0));
	        int maxWidth = 1;

	        while(!q.isEmpty()){
	            int currLevelSize = q.size();
	            while(currLevelSize-- > 0){
	            	Pair ele = q.poll();
	                q.poll();
	                if(ele.node.left != null){
	                    q.add(new Pair(ele.node.left, 2*(ele.idx) + 1));
	                }
	                if(ele.node.right != null){
	                    q.add(new Pair(ele.node.right, 2*(ele.idx) + 2));
	                }
	            }

	            Pair start = q.peekFirst();
	            Pair end = q.peekLast();
	            if(start!= null && end != null){
	                int width = end.idx - start.idx + 1;
	                maxWidth = Math.max(maxWidth, width);
	            }
	        }return maxWidth;
	    }

	    class Pair{
	        TreeNode node;
	        int idx;
	        Pair(TreeNode node, int idx){
	            this.node=node;
	            this.idx = idx;
	        }
	    }
}
