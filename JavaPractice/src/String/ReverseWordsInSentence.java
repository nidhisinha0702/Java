package String;

public class ReverseWordsInSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));

	}
	public static String reverseWords(String s) {
        //result string
        StringBuilder reversed = new StringBuilder();
        //trim leading/trailing space
        s = s.trim();
        //split on spaces
        String[] words = s.split(" ");
        //iterate over the array
        for(String word:words){
            //create a reversed word
            StringBuilder reversedWord = new StringBuilder(word);
            //append in ans with spaces
            reversed.append(reversedWord.reverse()).append(" ");
        }
        //remove the last added space
        reversed.deleteCharAt(reversed.length() - 1);
        return reversed.toString();
    }
}
