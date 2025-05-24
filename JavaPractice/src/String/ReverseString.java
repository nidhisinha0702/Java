package String;

public class ReverseString {

	public static void main(String[] args) {
		//there is no reverse method in string class
		String str = "123";
		System.out.println(reverse1(str));

	}
	
	private static String reverse(String in) {
		if(in == null)
			throw new IllegalArgumentException("Null is not valid input");
		StringBuilder out = new StringBuilder();
		
		char[] chars = in.toCharArray();
		
		for(int i=chars.length-1;i>=0;i--) {
			out.append(chars[i]);
		}
		return out.toString();
	}
	
	private static String reverse1(String in) {
		//take two pointers
		int i = 0;
		int j = in.length() - 1;
		//convert string to char array
		char[] chars = in.toCharArray();
		while(i < j) {
			//swap 1st and last chars
			char temp = chars[j];
			chars[j] = chars[i];
			chars[i] = temp;
			//move the pointers
			i++;
			j--;
		}
		
		//convert the char array back to string
		String reversed = new String(chars);//immutable
		return reversed;
	}

}
