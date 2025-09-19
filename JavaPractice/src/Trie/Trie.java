package Trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

	static Node root;
	
	public Trie() {
		root = new Node();
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println("Insert words : Striver, Striving, String, Strike");
		trie.insert("striver");
		trie.insert("striving");
		trie.insert("string");
		trie.insert("strike");
		
		 System.out.println("Search if Strawberry exists in trie: " +
	                (trie.search("strawberry") ? "True" : "False"));

	        System.out.println("Search if Strike exists in trie: " +
	                (trie.search("strike") ? "True" : "False"));

	        System.out.println("If words in Trie start with Stri: " +
	                (trie.startsWith("stri") ? "True" : "False"));

	}
	
	public static void insert(String word) {
		Node node = root;
		for(int i=0;i<word.length();i++) {
			if(!node.containsKey(word.charAt(i))) {
				node.put(word.charAt(i), new Node());
			}
			node = node.get(word.charAt(i));
		}
		node.setEnd();
		
	}
	
	public static boolean search(String word) {
		Node node = root;
		for(int i=0;i<word.length();i++) {
			if(!node.containsKey(word.charAt(i))) {
				return false;
			}
			node = node.get(word.charAt(i));
		}
		if(node.isEnd()) {
			return true;
		}
		return false;
	}
	
	static boolean startsWith(String word) {
		Node node = root;
		for(int i=0;i<word.length();i++) {
			if(!node.containsKey(word.charAt(i))) {
				return false;
			}
			node = node.get(word.charAt(i));
		}
		return true;
	}
	
	static boolean checkIfPrefixExists(String word) {
		boolean flag = true;
		Node node = root;
		for(int i=0;i<word.length();i++) {
			//if char exist
			if(node.containsKey(word.charAt(i))) {
				//go to ref node
				node = node.get(word.charAt(i));
				//check if ref nodes end is set to true
				flag = flag & node.isEnd();
			}else {
				return false;
			}
		}return flag;
	}
	
	public static String searchWord(String word) {
		Node node = root;
		String ans = "";
		for(int i=0;i<word.length();i++) {
			if(node.containsKey(word.charAt(i))) {
				ans += word.charAt(i);
			}node = node.get(word.charAt(i));
		}return ans;
	}
	
	static List<List<String>> getSuggestions(String str) {
		Node prev = root;
		List<List<String>> output = new ArrayList<>();
		String prefix = "";
		for(int i=0;i<str.length();i++) {
			
			prefix += str.charAt(i);
			char lastChar = prefix.charAt(i);
			//find the node corresponding to lastchar
			Node curr = prev.get(lastChar);
			
			//if not found
			if(curr == null) {
				break;
			}
			List<String> temp = new ArrayList<>();
			printSuggestions(curr, temp, prefix);
			output.add(temp);
			prev = curr;
		}return output;
	}

	private static void printSuggestions(Node curr, List<String> temp, String prefix) {
		//check if prefix ends at this node
		if(curr.isEnd()) {
			temp.add(prefix);
		}
		
		for(char i='a';i<='z';i++) {
			Node next = curr.get(i);
			
			if(next != null) {
				prefix += i+"";
				printSuggestions(next, temp, prefix);
				//prefix = prefix.substring(1);
			}
		}
	}

}
