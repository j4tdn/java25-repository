package Bai01;

public class Bai1 {
	
	public static boolean isPowerOf(int a, int b) {
		if(a <= 1 || b<= 1) {
			return false;
		}
		if(a == b) {
			return true;
		}
		if(a == b * b) {
			return true;
		}
		if(a == b * b * b) {
			return true;
		}
		if(b == a * a) {
			return true;
		}
		if(b == a * a * a) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOf(8, 2));
		System.out.println(isPowerOf(2, 8));
		System.out.println(isPowerOf(6, 2));
		System.out.println(isPowerOf(20, 4));
		System.out.println(isPowerOf(64, 4));
	}

}
