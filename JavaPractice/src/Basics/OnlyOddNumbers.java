package Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OnlyOddNumbers {

	public static void main(String[] args) {
		// Check if odd or not
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		System.out.println("list contains odd numbers : "+onlyOddNumbers1(list));
		

	}
	private static boolean onlyOddNumbers(List<Integer> list) {
		for(int i:list) {
			if(i % 2 == 0) return false;
		}return true;
	}

	private static boolean onlyOddNumbers1(List<Integer> list) {
		return list.parallelStream().allMatch(x->x % 2 != 0);//ensures every element satisfy the condition
	}
}
