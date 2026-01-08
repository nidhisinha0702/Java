package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListJoining {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<String> list = Arrays.asList("Apple","banana","kiwi","orange","grapes");
	       
	        String result = list.stream().collect(Collectors.joining(", ")); 
	        System.out.println(result);

	}

}
