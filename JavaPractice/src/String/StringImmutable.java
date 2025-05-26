package String;

public class StringImmutable {

	public static void main(String[] args) {
		//Prove string is immutable
		String s1 = "Java";
		String s2 = s1;
		System.out.println(s1 == s2); //true
		
		s1 = "Python";
		System.out.println(s1 == s2);//false
		System.out.println(s2);

	}

}
