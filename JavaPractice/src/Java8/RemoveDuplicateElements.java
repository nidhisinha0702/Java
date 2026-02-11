package Java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> list = Arrays.asList(51,100,110,100,200);
	        Set<Integer> set = new HashSet<>();
	        List<Integer> result = list.stream().filter(x->set.add(x)).collect(Collectors.toList());
	        System.out.println(result);

	}

}
