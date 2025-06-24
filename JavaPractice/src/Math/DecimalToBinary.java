package Math;

public class DecimalToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int decNum = 42;
		System.out.println("binary number will be : "+decimalToBinary(decNum));

	}
	private static int decimalToBinary(int DecNum) {
		int ans = 0, pow = 1;//2^0
		while(DecNum > 0) {
			int rem = DecNum % 2;
			DecNum /= 2;
			ans += rem * pow;
			pow *= 10;
		}return ans;
	}
}
