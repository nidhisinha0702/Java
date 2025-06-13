package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListToArray {

	public static void main(String[] args) {
		//WAP to convert arraylist to array
		List<Integer> al = new ArrayList<Integer>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);
        
        int arr[] = al.stream().mapToInt(i->i).toArray();
        
        System.out.println(Arrays.toString(arr));
        
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        
        System.out.println(list);

	}

}
