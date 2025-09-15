package demomain;

public class Ex01TestMainMethod {
	public static void main(String[] args) {
		System.out.println("Main: test the real one 1");
		System.out.println();
		main();
	}
	public static void main() {
		System.out.println("Main: test the real two 2");
	}
	public static void sum() {
		System.out.println("Test sum");
	}
	private static void sub() {
		System.out.println("Test sum");
	}
	public void mul() {
		System.out.println("Test mul");
	}
}
