package Tree;

public class LCA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null) return null;

        if(root.data == p.data || root.data == q.data)
           return root;
       Node leftLca = lowestCommonAncestor(root.left, p, q);
       Node rightLca = lowestCommonAncestor(root.right, p, q);

       if(leftLca != null && rightLca != null)
           return root;
       else if(leftLca != null){
           return leftLca;
       }else{
           return rightLca;
       }
   }
}
