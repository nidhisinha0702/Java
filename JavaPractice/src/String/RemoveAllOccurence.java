package String;

public class RemoveAllOccurence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "daabcbaabcbc", part = "abc";
		String ans = removeOccurrences(s, part);
		System.out.println(ans);

	}
	public static String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            s = s.replaceFirst(part, "");
        }return s;
    }
}
