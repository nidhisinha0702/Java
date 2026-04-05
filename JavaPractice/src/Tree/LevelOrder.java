package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        //root = [3,9,20,null,null,15,7]
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(levelOrder(root));
    }
    public static List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> temp = new ArrayList<>();
            while(level > 0){
                level--;
                Node node = q.poll();
                temp.add(node.data);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}
