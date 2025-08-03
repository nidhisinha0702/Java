package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Welcome to nidhi code and nidhi code welcome you";
		
		List<String> list = Arrays.asList(str.split(" "));
		
		//identity will return the same word and counting will return the count of that word
		Map<String, Long> mpp = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(mpp);
	}

}
