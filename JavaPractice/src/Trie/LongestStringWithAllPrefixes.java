package Trie;

public class LongestStringWithAllPrefixes {

	public static void main(String[] args) {
		LongestStringWithAllPrefixes obj = new LongestStringWithAllPrefixes();
		String[] a = {"n","ninja","ninj","ni","nin","ninga"};
		int n = a.length;
		System.out.println(completeString(n, a));

	}
	
	private static String completeString(int n, String[] a) {
		//create Trie obj
		Trie trie = new Trie();
		//insert all the string to it
		for(int i=0;i<n;i++) {
			trie.insert(a[i]);
		}
		//create a ans string
		String longest = "";
		//iterate over the string array
		for(int i=0;i<n;i++) {
			//check if prefix exists
			if(trie.checkIfPrefixExists(a[i]) && a[i].length() > longest.length()) {
				longest = a[i];
			}
			//check if they are equal then compare lexicographical order
			else if(a[i].length() == longest.length() && a[i].compareTo(longest) < 0) {
				longest = a[i];
			}
		}
		
		if(longest == "") return "None";
		return longest;
	}

}


