package Java8;

import java.util.Arrays;
import java.util.List;

public class TestPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> list = Arrays.asList(1,10,11,2,48,59);
	       
	        boolean result = list.stream().allMatch(x->x>0);
	        System.out.println(result);

	}

}
