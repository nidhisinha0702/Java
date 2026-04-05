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

    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        fun(root, p, q);
        return ans;
    }

    public int fun(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return 0;
        int left = fun(root.left, p, q);
        int right = fun(root.right, p, q);
        int self = 0;
        int total = 0;
        if(root.val == p.val || root.val == q.val)
        {
            self = 1;
        }
        total = left + right + self;
        if(total == 2 && ans == null){
            ans = root;
        }
        return total;
    }
}
