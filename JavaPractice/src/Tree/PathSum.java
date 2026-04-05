package Tree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return fun(root, targetSum, 0);

    }

    public boolean fun(TreeNode root, int targetSum, int sum){
        if(root == null) return false;
        sum = sum + root.val;
        if(root.left == null && root.right == null){
            if(sum == targetSum)
                return true;
        }
        return fun(root.left, targetSum, sum) ||
                fun(root.right, targetSum, sum);
    }
}
