package Arrays;

public class SecondLargest {

	public static void main(String[] args) {
		// WAP to find the second largest number in an array in java
		int highest = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;
		int array[] = {1,5,2,8,9,10,12};
		for(int i: array) {
			if(i > highest) {
			secondHighest = highest;
			highest = i;
			}else if(i > secondHighest) {
				secondHighest = i;
			}
		}
		System.out.println(secondHighest);

	}

}
