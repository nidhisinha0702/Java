package Trie;

public class NodeII {
	NodeII[] links = new NodeII[26];
	int cntEndWith = 0;
	int cntPrefix = 0;
	
	public NodeII() {
		
	}
	
	boolean containsKey(char ch) {
		return links[ch - 'a'] != null;
	}
	
	NodeII get(char ch) {
		return links[ch - 'a'];
	}
	
	void put(char ch, NodeII node) {
		links[ch - 'a'] = node;
	}
	
	void IncreaseEnd() {
		cntEndWith++;
	}
	
	void increasePrefix() {
		cntPrefix++;
	}
	
	void decreaseEnd() {
		cntEndWith--;
	}
	
	void reducePrefix() {
		cntPrefix--;
	}
	
	int getEnd() {
		return cntEndWith;
	}
	
	int getPrefix() {
		return cntPrefix;
	}
}
