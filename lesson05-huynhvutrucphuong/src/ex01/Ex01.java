package ex01;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println(isPowerOf(8, 2));
		System.out.println(isPowerOf(2, 8));
		System.out.println(isPowerOf(6, 2));
		System.out.println(isPowerOf(20, 4));
		System.out.println(isPowerOf(64, 4));
	}
	public static boolean isPowerOf(int a, int b) {
		if (a<= 0 || b<=1) {
			return false;
		}
		int power = 1;
		while (power < a ) {
			power *= b;
		}
		return power == a;
	}
}
