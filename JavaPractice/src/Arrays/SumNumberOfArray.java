package Arrays;

public class SumNumberOfArray {

	public static void main(String[] args) {
		//WAP to get the sum of all elements in an integer array
		int[] array = {1,2,3,4,5};
		int sum = 0;
		
		for(int i:array) {
			sum += i;
		}
		
		System.out.println(sum);

	}

}
