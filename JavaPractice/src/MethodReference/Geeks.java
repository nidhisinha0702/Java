package MethodReference;

import java.util.Arrays;

public class Geeks {

	public static void main(String[] args) {
		//WAP to demonstrate method reference
		String[] names = {"Geek1", "Geek2", "Geek3"};
		
		Arrays.stream(names).forEach(Geeks::print);

	}
	
	public static void print(String s) {
		System.out.println(s);
	}

}
