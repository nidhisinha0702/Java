package String;

public class RemoveWhiteSpaces {

	public static void main(String[] args) {
		//WAP to remove white spaces in java
		String s = "hello world java";
		s = s.replaceAll("\\s", "");
		String str = "hdgcn hjgs ";
		String ans = removeWhiteSpaces(str);
		System.out.println("After removing spaces : "+s);
		System.out.println("After removing spaces : "+ans);

	}
	
	private static String removeWhiteSpaces(String input) {
		StringBuilder output = new StringBuilder();
		
		char[] charArray = input.toCharArray();
		
		for(char c: charArray) {
			if(!Character.isWhitespace(c))
				output.append(c);
		}
		return output.toString();
	}

}
