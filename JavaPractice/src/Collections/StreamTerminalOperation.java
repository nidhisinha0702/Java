package Collections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTerminalOperation {

	public static void main(String[] args) {
		//WAP to demonstrate terminal operators
		List<String> names = Arrays.asList("Reflection","Collection","Stream","Structure","Sorting","State");
		
		System.out.println("forEach:");
		names.stream().forEach(System.out::println);
		
		//collect names starting with s
		List<String> sNames = names.stream().filter(name->name.startsWith("S")).collect(Collectors.toList());
		
		System.out.println("\n collect (names starting with 'S'):");
		sNames.forEach(System.out::println);
		
		//reduce: concatenate all names into a single string
		String  concatenatedNames = names.stream().reduce("", (partialString, element) -> partialString + " " + element);
		System.out.println("\nreduce (concatenated names) ");
		System.out.println(concatenatedNames.trim());
		
		//count the number of names
		long count = names.stream().count();
		System.out.println("\ncount:");
		System.out.println(count);
		
		//findfirst names
		Optional<String> firstName = names.stream().findFirst();
		System.out.println("\nfindFirst:");
		firstName.ifPresent(System.out::println);
		
		//allmatch
		boolean allStartsWithS = names.stream().allMatch(name->name.startsWith("S"));
		System.out.println("\nallMatch (all start with 'S'):");
		System.out.println(allStartsWithS);
		
		//anyMatch
		boolean anyStartWithS = names.stream().anyMatch(name->name.startsWith("S"));
		System.out.println("\nanyMatch (any start with 'S'):");
		System.out.println(anyStartWithS);
		
		

	}

}
