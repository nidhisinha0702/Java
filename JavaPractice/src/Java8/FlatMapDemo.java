package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FlatMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> list = Arrays.asList(Arrays.asList("A","B"), Arrays.asList("C","D"));
		list.stream().flatMap(List::stream).forEach(System.out::println);
		
		List<Integer> numbers = Arrays.asList(1,2,3,4);
		numbers.stream().peek(n->System.out.println("Processing: "+n)).map(n-> n * n).forEach(System.out::println);
		
		//completableFuture
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 1+2);
		future.thenAccept(System.out::println);
	}

}
