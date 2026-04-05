package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteBT {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        boolean nullFound = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            if(t == null){
                nullFound = true;
            }else{
                if(nullFound) return false;
                q.add(t.left);
                q.add(t.right);
            }
        }return true;

    }
}
