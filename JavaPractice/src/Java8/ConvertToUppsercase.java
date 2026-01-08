package Java8;

import java.util.Arrays;
import java.util.List;

public class ConvertToUppsercase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<String> list = Arrays.asList("hello","hi","how","are","you");
	        list.stream().map(String::toUpperCase).forEach(System.out::println);

	}

}
