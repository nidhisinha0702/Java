package Basics;

public class Factorial {

	public static void main(String[] args) {
		//WAP to find the factorial of a number
		int n = 5;
		int fact = fact(n);
		System.out.println("Factorial of n is "+fact);

	}
	private static int fact(int n) {
		if(n == 1)
			return 1;
		return n * fact(n-1);
	}

}
