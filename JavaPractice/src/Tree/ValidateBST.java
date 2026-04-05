package Tree;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        return fun(root, max, min);
    }
    public boolean fun(TreeNode root, long max, long min){
        if(root == null) return true;
        else if(root.val >= max || root.val <= min) return false;
        return fun(root.left, root.val, min) && fun(root.right, max, root.val);
    }
}
