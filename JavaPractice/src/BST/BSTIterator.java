package BST;

import java.util.Stack;

public class BSTIterator {
	
	Stack<Node> st = new Stack<>();
	
    public void storeLeftNodes(Node root){
        while(root != null){
            st.push(root);
            root = root.left;
        }
    }
    public BSTIterator(Node root) {
        storeLeftNodes(root);
    }
    
    public int next() {
        Node ans = st.peek();
        st.pop();

        if(ans.right != null)
            storeLeftNodes(ans.right);

        return ans.val;
    }
    
    public boolean hasNext() {
        return st.size() > 0;
    }
}
