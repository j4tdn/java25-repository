package datastructure.primitive;

public class Ex05SwapTest {
	public static void main(String[] args) {
		int a = 5;
		int b = 7;
		System.out.printf("Before:\n");
		System.out.println(a);
		System.out.println(b);

		b = swapTrick(a, a = b);

		System.out.printf("After:\n");
		System.out.println(a);
		System.out.println(b);
	}

	public static int swapTrick(int a, int b) {
		return a;
	}

}
