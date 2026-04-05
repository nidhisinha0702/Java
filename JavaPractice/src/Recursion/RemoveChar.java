package Recursion;
//remove all occurrences of character
public class RemoveChar {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("geeksforgeeks");
        char c = 'g';
        removeCharacter(sb,c);
        System.out.println("After removing char c: "+sb);
    }
    public static void removeCharacter(StringBuilder s, char c) {
        // code here
        int len = s.length();
        fun(s,0,len,c);

    }

    public static void fun(StringBuilder s, int i, int len, char c){
        if(i==len)
            return;

        fun(s, i+1, len, c);
        if(s.charAt(i) == c)
            s.deleteCharAt(i);

    }
}
