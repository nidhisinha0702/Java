package Tree;

import java.util.ArrayList;

public class TwoSumInBST {
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        int left = 0, right = inorder.size() - 1;
        while(left < right){
            int sum = inorder.get(left) + inorder.get(right);

            if(sum == k)    return true;
            else if(sum < k) left++;
            else right--;
        }return false;

    }
    public void inorderTraversal(TreeNode root, ArrayList<Integer> inorder){
        if(root == null) return;
        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
    }
}
