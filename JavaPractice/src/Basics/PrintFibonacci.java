package Basics;

public class PrintFibonacci {

	public static void main(String[] args) {
		// WAP to print fibonacci sequence
		int a = 0, b= 1, c = 1;
		int count = 10;
		for(int i=0;i<=count;i++) {
			System.out.print(a + ",");
			a = b;
			b = c;
			c = a + b;
		}
		System.out.println();
		int n = 10;
		System.out.println("A fibonacci sequence of "+n+" numbers: ");
		
		for(int i=0;i<n;i++) {
			System.out.print(fib(i)+" ");
		}

	}
	
	private static int fib(int n) {
		if(n <= 1)
			return n;
		return fib(n-1) + fib(n-2);
	}

}
