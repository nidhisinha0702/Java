package String;

public class ReverseWordsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "The sky is blue";
		System.out.println("reverse is : "+reverseWords(s));

	}
	//TC->O(n) SC->O(1)
	public static String reverseWords(String s) {
        int n = s.length();
        String ans = "";
        //reverse the whole string to get the words characters in place
        StringBuffer sb = new StringBuffer(s);
        s = sb.reverse().toString();

        for(int i=0;i<n;i++){
            //pick words one by one and create word
            String word = "";
            while(i < n && s.charAt(i) != ' '){
                word += s.charAt(i);
                i++;
            }
            //reverse each word
            StringBuffer sbWord = new StringBuffer(word);
            sbWord.reverse();
            //only if the word is valid
            if(sbWord.length() > 0){
                ans += " " + sbWord.toString();
            }
        }
        //remove the extra leading space from begining
        return ans.substring(1);
    }
}
