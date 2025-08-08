package Tree;

public class KthLevel {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.right.left = new Node(4);
		root.right.right = new Node(5);

		kthLevel(root, 3);

	}

	private static void kthLevel(Node root, int k) {
		if(root == null) return;
		
		if(k == 1) {
			System.out.print(root.data+" ");
			return;
		}
		
		kthLevel(root.left, k-1);
		kthLevel(root.right, k-1);
	}
}
