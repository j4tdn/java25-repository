package view;

public class Ex01IsPowerOf {

	public static void main(String[] args) {
		System.out.println("(8, 2) --> " + isPowerOf(8,2));
		System.out.println("(2, 8) --> " + isPowerOf(2,8));
		System.out.println("(6, 2) --> " + isPowerOf(6,2));
		System.out.println("(20, 4) --> " + isPowerOf(20,4));
		System.out.println("(64, 4) --> " + isPowerOf(64,4));
		System.out.println("(3, 4) --> " + isPowerOf(3,4));
	}
	
	private static boolean isPowerOf(int a, int b) {
		if(a < 1 && b < 1) {
			return false;
		} 
		return a > b ? a%b == 0 : b%a == 0;
	}
	
}
