package String;

public class RemoveAllOccurences {

	public static void main(String[] args) {
		//WAP to remove all occurrences of a char from a string
		String str1 = "abcdABCDabcdABCD";
		
		str1 = str1.replace("a", "");
		
		System.out.println(str1);
	}

}
