package Math;

public class DigitsInNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3568;
		System.out.println((int)Math.log10(n)+1);
		printDigits(n);
		System.out.println(countDigits(n));
		System.out.println(sumDigits(n));
		
		int num = 153;
		if(isArmstrong(num)) {
			System.out.println("Armstrong Number");
		}else {
			System.out.println("Not An Armstrong Number");
		}

	}
	private static void printDigits(int n) {
		while(n != 0) {
			int digit = n % 10;
			System.out.print(digit+" ");
			n /= 10;
		}
	}
	private static int countDigits(int n) {
		int count = 0;
		while(n != 0) {
			int digit = n % 10;
			count++;
			n /= 10;
		}return count;
	}
	private static int sumDigits(int n) {
		int sum = 0;
		while(n != 0) {
			int digit = n % 10;
			sum += digit;
			n /= 10;
		}return sum;
	}
	
	private static boolean isArmstrong(int n) {
		int copyN = n;
		int sumOfCubes = 0;
		while(n!= 0) {
			int digit = n % 10;
			sumOfCubes += (digit * digit * digit);
			n /= 10;
		}
		return sumOfCubes == copyN;
	}
}
