package Collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Practice {

	public static void main(String[] args) {
		// Given a list of integers, filter out the even numbers and collect them into a new list
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		List<Integer> evenNumbers = numbers.stream().filter(n->n%2 == 0).collect(Collectors.toList());
		System.out.println(evenNumbers);
		
		//Given a list of strings, convert them to uppercase and collect them into a new list
		List<String> words = Arrays.asList("hello", "world","java");
		List<String> upperCaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(upperCaseWords);
		
		//calculate the sum of all elements in a list of integers
		List<Integer> num = Arrays.asList(1,2,3,4,5);
		int sum = num.parallelStream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);
		
		//Find the maximum element in a list of integers
		List<Integer> nums = Arrays.asList(1,5,2,8,3);
		Optional<Integer> max = nums.stream().max(Integer::compare);
		System.out.println(max.get());
		
		//remove duplicate elements from a list
		List<String> names = Arrays.asList("Alice", "Bob", "Alice", "Charlie");
		List<String> distinctNames = names.stream().distinct().collect(Collectors.toList());
		System.out.println(distinctNames);
		
		//sort a list in descending order
		List<Integer> order = Arrays.asList(3,5,1,4,2);
		List<Integer> sortedOrder = order.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(sortedOrder);
		
		//count strings with specific prefix
		List<String> namesPre = Arrays.asList("Alice","Bob","Annie","Alex","Charlie");
		long count = namesPre.stream().filter(name->name.startsWith("A")).count();
		System.out.println(count);
		
		//Find first non-repeated character in a string
		String input = "swiss";
		Optional<Character> firstNonRepeated = input.chars().mapToObj(c->(char)c).filter(c->input.indexOf(c) == input.lastIndexOf(c))
				.findFirst();
		System.out.println(firstNonRepeated.orElse(null));
		
		//check if any string matches a condition
		List<String> strings = Arrays.asList("Java", "Stream API","Lambda");
		boolean containsAPI = strings.stream().anyMatch(s->s.contains("API"));
		System.out.println(containsAPI);
		
		//find duplicate elements in a list
		List<Integer> nos = Arrays.asList(1,2,3,4,2,5,1);
		Set<Integer> unique = new HashSet<>();
		Set<Integer> duplicates = nos.stream().filter(n-> !unique.add(n)).collect(Collectors.toSet());
		System.out.println(duplicates);
		
		//group strings by length
		List<String> word = Arrays.asList("Java","Stream","API","Code","Fun");
		Map<Integer, List<String>> groupByLength = word.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(groupByLength);
		
		//Flatten a list of list
		List<List<Integer>> listOfList = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(4,5), Arrays.asList(6,7,8,9));
		List<Integer> flattenedList = listOfList.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println(flattenedList);
		
		//Concatenate Strings
		List<String> wrds = Arrays.asList("Stream","API","is","powerful");
		String concatenated = wrds.stream().reduce("", (s1,s2) -> s1 +" "+ s2).trim();
		System.out.println(concatenated);
		
		//find the longest string
		List<String> wrd = Arrays.asList("Java","Stream","API","Development");
		String longest = words.stream().reduce((word1, word2) -> word1.length() > word2.length() ? word1:word2).orElse(null);
		System.out.println(longest);
		
		//Count Frequency of character in a string
		String inputLong = "success";
		Map<Character, Long> frequency = inputLong.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c, Collectors.counting()));
		System.out.println(frequency);
		
	}

}
