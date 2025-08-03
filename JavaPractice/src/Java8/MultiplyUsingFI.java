package Java8;

public class MultiplyUsingFI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunInt fi = (a,b) -> a*b;
		
		System.out.println(fi.multiple(6, 7));
	}

}
