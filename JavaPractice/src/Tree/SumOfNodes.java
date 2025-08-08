package Tree;

public class SumOfNodes {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		System.out.println(sum(root));
		System.out.println(isIdentical(root, root));
		System.out.println(isSubTree(root, root));
		System.out.println(diameter(root));
		System.out.println(diameterOpti(root));
	}
	private static int sum(Node root) {
		if(root == null) return 0;
		
		int leftSum = sum(root.left);
		int rightSum = sum(root.right);
		return (leftSum + rightSum + root.data);
	}
	
	private static boolean isIdentical(Node p, Node q) {
		if(p == null || q == null)
			return p == q;
		
		boolean isLeftSame = isIdentical(p.left, q.left);
		boolean isRightSame = isIdentical(p.right, q.right);
		
		return (isLeftSame && isRightSame && (p.data == q.data));
	}
	
	private static boolean isSubTree(Node root, Node subRoot) {
		if(root == null || subRoot == null)
			return root == subRoot;
		
		if(root.data == subRoot.data && isIdentical(root, subRoot))
			return true;
		
		return (isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot));
	} 
	//O(n^2)
	private static int diameter(Node root) {
		if(root == null) return 0;
		
		int leftDiam = diameter(root.left);
		int rightDiam = diameter(root.right);
		int currDiam = height(root.left) + height(root.right);
		return Math.max(leftDiam, Math.max(rightDiam, currDiam));
	}
	
	private static int height(Node root) {
		if(root == null) return 0;
		
		int lH = height(root.left);
		int rH = height(root.right);
		return Math.max(lH, rH) + 1;
	}
	
	//O(n)
	static int ans = 0;
	private static int diameterOpti(Node root) {
		heightDiam(root);
		return ans;
	}
	
	private static int heightDiam(Node root) {
		if(root == null) return 0;
		
		int lH = height(root.left);
		int rH = height(root.right);
		ans = Math.max(ans,  lH+rH);
		return Math.max(lH, rH) + 1;
	}
	
}
