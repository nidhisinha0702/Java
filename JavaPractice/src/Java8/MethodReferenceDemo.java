package Java8;

public class MethodReferenceDemo {

	public static void main(String[] args) {
		FunctionalInterfaceDemo funDemo = Test :: testImpl;
		funDemo.singleAbstractMethod();
		
//		FunctionalInterfaceDemo f = () -> System.out.println("Impl of SAM");
//		f.singleAbstractMethod();

	}

}

class Test{
	public static void testImpl() {
		System.out.println("This is test implementation of your abstract method");
	}
}
