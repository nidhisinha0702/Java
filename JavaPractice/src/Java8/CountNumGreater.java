package Java8;

import java.util.Arrays;
import java.util.List;

public class CountNumGreater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(51,10,112,130,21,108,19,20,203);
        long result = list.stream().filter(x->x>50).count();
        System.out.println(result);

	}

}
