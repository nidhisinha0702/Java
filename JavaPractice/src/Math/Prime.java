package Math;

import java.util.Arrays;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.println("The number is : "+isPrime(n));
		int N = 50;
		System.out.println("Number of prime numbers is : "+countPrimes(N));
	}
	
	private static String isPrime(int n) {
		for(int i=2;i*i<=n;i++) {
			if(n % i == 0)
				return "Not Prime";
		}return "Prime";
	}
	//sieve of eratosthenes 
	private static int countPrimes(int n) {
		boolean isPrime[] = new boolean[n+1];
		Arrays.fill(isPrime, true);
		int count = 0;
		for(int i=2;i<n;i++) {
			if(isPrime[i]) {
				count++;
				for(int j=i*2;j<n;j=j+i) {
					isPrime[j] = false;
				}
			}
		}return count;
	}	

}
