package Recursion;

public class PalindromeString {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println("String s is palindrome : "+isPalindrome(s));
    }
    static boolean isPalindrome(String s) {
        // code here
        int len = s.length();
        return fun(s,0,len-1);
    }
    static boolean fun(String s, int low, int high){
        int len = high - low + 1;
        if(len == 0 || len == 1)
            return true;

        if(s.charAt(low) != s.charAt(high)) return false;

        return fun(s, low + 1, high - 1);
    }
}
