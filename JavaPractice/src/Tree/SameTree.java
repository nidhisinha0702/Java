package Tree;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if(p == null || q == null) return false;
        else if(p.val != q.val) return false;
        boolean r1 = isSameTree(p.left, q.left);
        boolean r2 = isSameTree(p.right, q.right);
        return r1 && r2;
    }
}
