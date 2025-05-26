package Collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperationDemo {

	public static void main(String[] args) {
		// WAP to demonstrate stream intermediate operation
		
		List<List<String>> listOfLists = Arrays.asList(Arrays.asList("Reflection","Collection","Stream"),
			Arrays.asList("Structure","State","Flow"), Arrays.asList("Sorting","Mapping","Reduction","Stream"));
		
		
		//create a set to hold intermediate results
		Set<String> intermediateResults = new HashSet<>();
		
		//flatten the list of lists into a single stream
		List<String> result = listOfLists.stream().flatMap(List::stream)
				.filter(s->s.startsWith("S"))//filter elements starting with 
				.map(String::toUpperCase) //transform each element to uppercase
				.distinct() //remove duplicate
				.sorted() //sort elements
				.peek(s->intermediateResults.add(s))//perform an action add to set on each element
				.collect(Collectors.toList());
		
		System.out.println("Intermediate Result");
		intermediateResults.forEach(System.out::println);
		
		//print the final result
		System.out.println("Final Results:");
		result.forEach(System.out::println);

	}

}
