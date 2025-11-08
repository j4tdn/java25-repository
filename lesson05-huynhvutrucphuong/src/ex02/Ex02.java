package ex02;

public class Ex02 {
	public static void main(String[] args) {
		int A1[] = {3, 2, 1, 6, 5};
		int A2[] = {3, 7, 9, 2, 1, 6, 5, 4, 10};
		System.out.println(getMissingNumber(A1, 6));
		System.out.println(getMissingNumber(A2, 10));
	}
	public static int getMissingNumber(int a[], int n ) {
		int total = n*(n+1)/2;
		int sum = 0;
		for (int x : a) {
			sum+= x;
		}
		return total - sum ;
	}
}
