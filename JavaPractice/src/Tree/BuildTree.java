package Tree;

public class BuildTree {

	static int idx = -1;
	static Node buildTree(int[] preOrder) {
		idx++;
		
		if(preOrder[idx] == -1) return null;//base case
		
		Node root = new Node(preOrder[idx]);
		root.left = buildTree(preOrder);//left
		root.right = buildTree(preOrder);//right
		
		return root;
	}
	public static void main(String[] args) {
		int preOrder[] = {1,2,-1,-1,3,4,-1,-1,5,-1,-1};
		Node root = buildTree(preOrder);
		System.out.println("build tree :"+root.data);
		System.out.println("left tree :"+root.left.data);
		System.out.println("right tree :"+root.right.data);
	}

}
class Node{
	int data;
	Node left, right;
	
	Node(int val){
		data = val;
		left = right = null;
	}
}
