package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> list = Arrays.asList(51,100,110,100,200);
	       
	        List<Integer> asc = list.stream().sorted().collect(Collectors.toList());
	        List<Integer> desc = list.stream().sorted((a,b)->Integer.compare(b,a)).collect(Collectors.toList());
	        System.out.println(asc);
	        System.out.println(desc);

	}

}
