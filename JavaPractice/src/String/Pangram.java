package String;

public class Pangram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence = "thequickbrownfoxjumpsoverthelazydog";
		System.out.println(checkIfPangram(sentence));

	}
	
	public static boolean checkIfPangram(String sentence) {
	       for(char ch='a';ch<='z';ch++){
	        if(!sentence.contains(ch+"")){
	            return false;
	        }
	       }return true;
	    }

}
