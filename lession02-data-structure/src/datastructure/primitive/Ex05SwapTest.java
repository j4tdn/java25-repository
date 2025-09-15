package datastructure.primitive;

public class Ex05SwapTest {
	public static void main(String[] args) {

		int a1 = 5;
		int a2 = 7;

		System.out.println("a1: " + a1);
		System.out.println("a2: " + a2);
		
		//swap(a1, a2);
		a2 = swaptrick(a1, a1 = a2);
		
		
		int temp = a1;
		a1 = a2;
		a2 = temp;

		System.out.println("--- After Swap ---");

		System.out.println("a1: " + a1);
		System.out.println("a2: " + a2);

	}
	private static int swaptrick(int a1, int a2) {
		return a1;
	}
	private static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
}
