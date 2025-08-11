package Trie;

public class TrieBit {
	//root of the trie
	NodeBit root;
	
	TrieBit(){
		root = new NodeBit();
	}
	
	//insert method
	void insert(int num) {
		
		NodeBit node = root;
		//iterate from 31st bit
		for(int i = 31;i>=0;i--) {
			//extract the ith bit of the number
			int bit = (num >> 1) & 1;
			
			//bit does not exist
			if(!node.containsKey(bit)) {
				node.put(bit, new NodeBit());
			}
			
			//move to next trie node
			node = node.get(bit);
		}
	}
	
	//find max possible xor value
	int getMax(int n) {
		NodeBit node = root;
		
		int maxNum = 0;
		
		//iterate from 31st bit
		for(int i=31;i>=0;i--) {
			//extract the ith bit of the n
			int bit = (n >> i) & 1;
			
			//check if the complement bit exist in the current bit
			if(node.containsKey(1-bit)) {
				//update the max xor
				maxNum |= (1 << i);
				//maxNum ^= (1 - bit);
				node = node.get(1-bit);
			}else {
				node = node.get(bit);
			}
		}return maxNum;
	}
}
