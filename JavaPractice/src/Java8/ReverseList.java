package Java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseList {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(217, 317, 417, 517);
		Stream<Integer> stream = list.parallelStream();
		
		stream.collect(reverseStream()).forEach(System.out::println);

	}
	
	public static <T> Collector<T, ?, Stream<T>> reverseStream(){
		return Collectors.collectingAndThen(Collectors.toList(), list -> {
			Collections.reverse(list);
		return list.stream();
		});
	}

}
