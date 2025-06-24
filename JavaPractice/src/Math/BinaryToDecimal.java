package Math;

public class BinaryToDecimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int binNum = 101010;
		System.out.println("Decimal number will be : "+binaryToDecimal(binNum));

	}
	
	private static int binaryToDecimal(int binNum) {
		int ans = 0, pow = 1;//2^0
		while(binNum >0) {
			int rem = binNum % 2;
			ans += rem * pow;
			binNum /= 10;
			pow *= 2;
		}return ans;
	}

}
