package Basics;

public class PrimeNumberCheck {

	public static void main(String[] args) {
		// WAP to check if a number is prime or not
		System.out.println(isPrime(19));//true
		System.out.println(isPrime(29));//true
		System.out.println(isPrime(39));//false
		System.out.println(isPrime(49));//false
	}
	
	private static boolean isPrime(int n) {
		if(n <= 1) return false;
		
		for(int i =2 ;i<=Math.sqrt(n);i++) {
			if(n % i == 0)
				return false;
		}
		return true;
	}

}
