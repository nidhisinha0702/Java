package Java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Prime {

	public static void main(String[] args) {
		System.out.println(isPrime(11));
		sqrtOf10Prime(10);
	}
	
	private static boolean isPrime(int num) {
		//num > 1 && iterate from 2, num and noneMatch (no n should completely divide num)
		return num > 1 && IntStream.range(2,  num).noneMatch(n-> num%n == 0);
	}
	
	private static void sqrtOf10Prime(int n) {
		List<Double> sqrt = Stream.iterate(1, i->i+1).filter(Prime :: isPrime).map(Math::sqrt)
				.limit(10).collect(Collectors.toList());
		System.out.println(sqrt);
	}
	

}
