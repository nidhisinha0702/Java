package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZag {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        System.out.println(zigzagLevelOrder(root));
    }
    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<Node> q = new LinkedList<>();
        q.addLast(root);
        boolean reverse = false;
        while(!q.isEmpty()){
            int level = q.size();
            List<Integer> temp = new ArrayList<>();
            while(level-- > 0){
                if(reverse){
                    Node node = q.removeLast();
                    temp.add(node.data);
                    if(node.right != null) q.addFirst(node.right);
                    if(node.left != null) q.addFirst(node.left);
                }
                else{
                    Node node = q.removeFirst();
                    temp.add(node.data);
                    if(node.left != null) q.addLast(node.left);
                    if(node.right != null) q.addLast(node.right);
                }

            }reverse = !reverse;
            res.add(temp);
        }return res;
    }
}
