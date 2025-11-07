package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SenarioBasedQnA {

	public static void main(String[] args) {
		//given a list of strings and need to filter out those that start with the letter 'A', then convert the remaining strings to uppercase
		List<String> words = Arrays.asList("Apple","Banana","Apricot","Orange");
		List<String> result = words.stream().filter(s->!s.startsWith("A")).map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(result);
		
		//check for palindrome
		String input = "madam";
		boolean isPalindrome = IntStream.range(0,  input.length()/2).allMatch(i->input.charAt(i) == input.charAt(input.length() - i-1));
		System.out.println(isPalindrome);
		
		//counting character occurrences
		String str = "interview";
		Map<Character, Long> charCount = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(charCount);
		
		
		
	}

}
