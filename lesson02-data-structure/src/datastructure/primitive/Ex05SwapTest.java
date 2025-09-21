package datastructure.primitive;

public class Ex05SwapTest {
	
	public static void main(String[] args) {
		int a1 = 5;
		int a2 = 7;
		
		System.out.println("a1: " + a1);
		System.out.println("a2: " + a2);
		
		a2 = swapTrick(a1, a1 = a2);
		
		System.out.println("--- After Swap ---");
		
		System.out.println("a1: " + a1);
		System.out.println("a2: " + a2);
	}
	
	private static int swapTrick(int a1, int a2) {
		return a1;
	}
	
	// Viết hàm swap 2 số nguyên
	private static void swap(int a1, int a2) {
		int temp = a1;
		a1 = a2;
		a2 = temp;
	}
	
}