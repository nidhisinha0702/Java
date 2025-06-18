package Recursion;

public class PermutationString {

	public static void main(String[] args) {
		//WAP to print all the permutation of a string
		String s = "abc";
		findPermutation(s);
		

	}
	
	private static void findPermutation(String s) {
		StringBuilder sb = new StringBuilder(s);
		getPermsStr(sb, 0);
	}
	
	private static void getPermsStr(StringBuilder str, int idx) {
		//bc
		if(idx == str.length()) {
			System.out.println(str.toString());
			return;
		}
		
		for(int i=idx;i<str.length();i++) {
			swap(idx, i, str);
			getPermsStr(str, idx + 1);
			//backtrack
			swap(idx, i, str);
		}
	}
	
	private static void swap(int l, int r, StringBuilder s) {
		char temp = s.charAt(l);
		s.setCharAt(l, s.charAt(r));
		s.setCharAt(r, temp);
	}

}
