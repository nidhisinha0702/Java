package Tree;

public class DiameterOfBT {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        fun(root);
        return ans;
    }

    public int fun(TreeNode root){
        if(root == null) return 0;
        int left = fun(root.left);
        int right = fun(root.right);
        int sum = left + right;
        ans = Math.max(ans, sum);
        return 1 + Math.max(left, right);
    }
}
