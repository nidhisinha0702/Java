package Trie;

public class NodeBit {
	NodeBit links[];
	
	NodeBit() {
		links = new NodeBit[2];
	}
	
	boolean containsKey(int bit) {
		return links[bit] != null;
	}
	
	NodeBit get(int bit) {
		return links[bit];
	}
	
	void put(int bit, NodeBit node) {
		links[bit] = node;
	}
}
