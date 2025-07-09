package Math;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 4537;
		System.out.println("reverse is "+reverse(num));
		int n = 353;
		System.out.println("palindrome "+palindrome(n));
	}
	
	private static int reverse(int n) {
		int revNum = 0;
		while(n != 0) {
			int dig = n % 10;
			if(revNum > Integer.MAX_VALUE/10 || revNum < Integer.MIN_VALUE/10) {
				return 0;
			}
			revNum = revNum * 10 + dig;
			n = n/10;
		}return revNum;
	}
	
	private static boolean palindrome(int n) {
		if(n < 0) return false;
		int rev = reverse(n);
		return n == rev;
	}
}
