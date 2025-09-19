package Java8;

@FunctionalInterface
public interface FunctionalInterfaceDemo {

	abstract void singleAbstractMethod();
	
	public static void printName() {
		System.out.println("Welcome to codewithnidhi");
	}
	
	public default void printNameAgain() {
		System.out.println("Welcome to codewithnidhi Again");
	}
}
