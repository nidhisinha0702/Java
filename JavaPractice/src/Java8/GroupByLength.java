package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> words = Arrays.asList("a","bb","ccc","dd");
		Map<Integer, List<String>> grouped = words.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(grouped);
	}

}
