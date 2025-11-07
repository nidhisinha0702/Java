package Java8;

import java.util.Arrays;
import java.util.List;

public class ReduceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(1,2,3,4);
		int prod = numbers.stream().reduce(1, (a,b) -> a*b);
		System.out.println(prod);
		int sum = numbers.stream().reduce(0, (a,b) -> a+b);
		System.out.println(sum);

	}

}
