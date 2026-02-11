package Java8;

import java.util.Arrays;
import java.util.List;

public class FindFirst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  List<Integer> list = Arrays.asList(1,10,11,2,48,59);
	       
	        int result = list.stream().filter(x->x>10).findFirst().orElse(-1); 
	        System.out.println(result);

	}

}
