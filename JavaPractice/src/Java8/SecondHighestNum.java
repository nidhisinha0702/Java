package Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SecondHighestNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> nums = Arrays.asList(1,2,3,2,5,5,7,8,8,10);
	       
	       Optional<Integer> result = nums.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
	       System.out.println(result.get());

	}

}
