package Math;

public class GCD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=20,b=24;
		System.out.println(gcd(a,b));
		System.out.println(gcdEuclid(a, b));
		System.out.println(gcdEuclidRec(a, b));
		System.out.println(lcm(a, b));
	}
	//Tc->O(min(a,b)
	private static int gcd(int a, int b) {
		int gcd = 1;
		for(int i=1;i<=Math.min(a, b);i++) {
			if(a%i == 0 && b%i == 0) {
				gcd = i;
			}
		}return gcd;
	}
	//Iterative
	private static int gcdEuclid(int a, int b) {
		while(a > 0 && b > 0) {
			if(a > b) {
				a = a % b;
			}else {
				b = b % a;
			}
		}
		if(a==0) return b;
		return a;
	}
	private static int gcdEuclidRec(int a, int b) {
		if(b==0) return a;
		//we consider 1st value as the bigger one
		return gcdEuclidRec(b, a%b);
	}
	
	private static int lcm(int a, int b) {
		int gcd = gcdEuclidRec(a,b);
		int lcm = (a * b)/gcd;
		return lcm;
	}
}
