package Java8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hellohi";
		Map<Character, Long> count = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		Optional<Character> ch = count.entrySet().stream().filter(entry->entry.getValue()==1L).map(Map.Entry::getKey).findFirst();
		System.out.println(ch.get());
		//frequency of each character in a string
		System.out.println(count);

	}

}
