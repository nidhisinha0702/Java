package fastslowpointer;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 19;
		System.out.println(n + " is a happy number : "+isHappy(n));

	}
	 public static boolean isHappy(int n) {
	        int slow = n, fast = n;
	        while(fast != 1){
	            slow = fun(slow);
	            fast = fun(fast);
	            fast = fun(fast);
	            if(slow == fast && slow != 1){
	                return false;
	            }
	        }return true;
	    }
	    static int fun(int n){
	        int sum = 0;
	        while(n > 0){
	            int rem = n % 10;
	            n = n/10;
	            sum += rem * rem;
	        }return sum;
	    }

}
