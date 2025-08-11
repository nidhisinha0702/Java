package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Node cloneGraph(Node node) {
		//if the node is null
		if(node == null)
			return null;
		
		HashMap<Node,Node> nodeMap = new HashMap<>();
		return cloneNode(node, nodeMap);
	}
	
	private static Node cloneNode(Node node, HashMap<Node, Node> nodeMap) {
		//if the node is already cloned
		if(nodeMap.containsKey(node)) {
			return nodeMap.get(node);
		}
		
		//if not create copy node with same val
		Node copy = new Node(node.val);
		//put in map
		nodeMap.put(node, copy);
		//go to neighbors
		for(Node neigh:node.neighbors) {
			copy.neighbors.add(cloneNode(neigh, nodeMap));
		}
		
		return copy;
	}

}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
