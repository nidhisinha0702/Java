package Java8;

import java.util.Arrays;
import java.util.List;

public class AnyMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer> list = Arrays.asList(1,10,11,2,45,59);
	       
	        boolean result = list.stream().anyMatch(x->x%5==0);
	        System.out.println(result);

	}

}
