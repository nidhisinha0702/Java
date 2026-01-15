package Java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<List<Integer>> listOfList = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(2,5,5),Arrays.asList(7,8,8,10));
	       
	       List<Integer> flatlist = listOfList.stream().flatMap(List::stream).collect(Collectors.toList());
	       System.out.println(flatlist);

	}

}
