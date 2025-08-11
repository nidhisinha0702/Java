package Trie;

public class TrieII {

	private NodeII root;
	
	public TrieII() {
		root = new NodeII();
	}
	
	public void insert(String word) {
		NodeII node = root;
		for(int i=0;i<word.length();i++) {
			//if char does not exist put and create ref trie
			if(!node.containsKey(word.charAt(i))) {
				node.put(word.charAt(i), new NodeII());
			}
			//go to ref trie
			node = node.get(word.charAt(i));
			//increase prefix count
			node.increasePrefix();
		}
		//at the end increase endsWith
		node.IncreaseEnd();
	}
	
	public int countWordsEqualTo(String word) {
		NodeII node = root;
		for(int i=0;i<word.length();i++) {
			//if char exist go to ref trie
			if(node.containsKey(word.charAt(i))) {
				//go to ref trie
				node = node.get(word.charAt(i));
			}else//return 0 if not
				return 0;
		}
		//return endwithcnt
		return node.getEnd();
	}
	
	public int countWordsStartingWith(String word) {
		NodeII node = root;
		for(int i=0;i<word.length();i++) {
			//if char exist go to ref trie
			if(node.containsKey(word.charAt(i))) {
				//go to ref trie
				node = node.get(word.charAt(i));
			}else//return 0 if not
				return 0;
		}
		//return cntPrefix
		return node.getPrefix();
	}
	
	public void erase(String word) {
		NodeII node = root;
		for(int i=0;i<word.length();i++) {
			//if char exist go to ref trie
			if(node.containsKey(word.charAt(i))) {
				//go to ref trie
				node = node.get(word.charAt(i));
				//decrese cntPrefix
				node.reducePrefix();
			}else {//return
				return;
			}
		}node.decreaseEnd();//at end decrease endwithcnt
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 TrieII trie = new TrieII();
	        trie.insert("apple");
	        trie.insert("app");
	        System.out.println("Inserting strings 'apple', 'app' into Trie");
	        System.out.print("Count Words Equal to 'apple': ");
	        System.out.println(trie.countWordsEqualTo("apple"));
	        System.out.print("Count Words Starting With 'app': ");
	        System.out.println(trie.countWordsStartingWith("app"));
	        System.out.println("Erasing word 'app' from trie");
	        trie.erase("app");
	        System.out.print("Count Words Equal to 'apple': ");
	        System.out.println(trie.countWordsEqualTo("apple"));
	        System.out.print("Count Words Starting With 'apple': ");
	        System.out.println(trie.countWordsStartingWith("app"));
	}

}
