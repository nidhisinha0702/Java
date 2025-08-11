package Trie;

import java.util.ArrayList;
import java.util.List;

public class PhoneDirectory {
	//creation of trie
	static Trie trie = new Trie();
	public static void main(String[] args) {
		List<String> contact = new ArrayList<>();
		contact.add("cod");
		contact.add("coding");
		contact.add("codding");
		contact.add("code");
		contact.add("coly");
		String queryStr = "coding";
		System.out.println(phoneDirectory(contact, queryStr));
	}
	
	private static List<List<String>> phoneDirectory(List<String> contactList, String queryStr){
		
		//insert all the contact in trie
		for(int i=0;i<contactList.size();i++) {
			String str = contactList.get(i);
			trie.insert(str);
		}
		
		//return ans
		return trie.getSuggestions(queryStr);
	}
}
