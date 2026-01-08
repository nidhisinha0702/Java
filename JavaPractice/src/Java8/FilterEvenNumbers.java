package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEvenNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> list = Arrays.asList(5,10,12,13,11,18,19,20,23);
	        List<Integer> result = list.stream().filter(x->x%2==0).collect(Collectors.toList());
	        System.out.println(result);

	}

}
