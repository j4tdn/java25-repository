package demomain;

public class Ex01TextMainMethod {
	public static void main(String[] args) {
		System.out.println("Main: Test the real one2");
		System.out.println("===========");
		main();
		sum();
		mul();
		
	}
	
	public static void main() {
		System.out.println("Main: Test the fake one 1");
		System.out.println("===========");
	}
	
	public static void sum() {
		System.out.println("Test sum method");
		System.out.println("===========");
	}
	
	public static void mul() {
		System.out.println("Test mul method");
		
	}

} 
