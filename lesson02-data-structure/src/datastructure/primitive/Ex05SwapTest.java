package datastructure.primitive;

public class Ex05SwapTest {
	public static void main(String[] args) {

		int a1 = 5;
		int a2 = 7;

		System.out.println("a1: " + a1);
		System.out.println("a2: " + a2);

		swap(a1, a2);

		int temp = a1; // temp = 5
		a1 = a2;// a1 = 7
		a2 = temp; // a2 = 5

		System.out.println("--- After Swap---");

		System.out.println("a1: " + a1);
		System.out.println("a2: " + a2);
	}

	// Viết hàm swap 2 số nguyên
	// int arg1 = 1; int arg2 = 2;
	private static void swap(int arg1, int arg2) {
		int temp1 = arg1; // temp = 1
		arg1 = arg2;// a1 = 2
		arg2 = temp1; // a2 = 5
	}

}
