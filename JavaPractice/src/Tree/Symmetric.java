package Tree;

public class Symmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        else if(p == null || q == null) return false;
        else if(p.val !=  q.val) return false;
        boolean r1 = isMirror(p.left, q.right);
        boolean r2 = isMirror(p.right, q.left);
        return r1 && r2;
    }
}
