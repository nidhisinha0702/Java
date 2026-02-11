package Java8;

import java.util.Arrays;
import java.util.List;

public class SumAvgMinMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
	        int sum = list.stream().mapToInt(Integer::intValue).sum();
	        double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
	        int min = list.stream().mapToInt(Integer::intValue).min().orElse(Integer.MIN_VALUE);
	        int max = list.stream().mapToInt(Integer::intValue).max().orElse(Integer.MAX_VALUE);
	        System.out.println(sum);
	        System.out.println(avg);
	        System.out.println(min);
	        System.out.println(max);

	}

}
