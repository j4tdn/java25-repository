package Ex05;

public class HappyNumber {
	public static void main(String[] args) {
		int n =44;
		if(isHappy(n)) {
			System.out.println(n + "la so hanh phuc");
			
		}else {
			System.out.println(n + "kh la so hanh phuc");
		}
	}
	public static boolean isHappy(int n) {
		int count = 0;
		while(n != 1 && count <100) {
			n = sumHappy(n);
			count++;
			
		}
		return n==1;
	}
	public static int sumHappy(int n) {
		int sum = 0;
		while(n >0) {
			int d = n %10;
			sum += d*d;
			n/= 10;
		}
		return sum;
	}
}
