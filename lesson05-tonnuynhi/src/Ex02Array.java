/*
 * Bài 2 (15đ):Cho mảngA gồm n-1 phần tử không trùng nhau, giá trị của mỗi phần
tử trong mảng, Ak = [1, n].
Tìm số nguyên còn lại trong khoảng [1, n] không tồn tại trong mảng A.
▪ VD1: n = 6, Ak = [3, 2, 1, 6, 5]
▪ Phần tử cần tìm có giá trị: 4
▪ VD2: n = 10, Ak = [3, 7, 9, 2, 1, 6, 5, 4, 10]
▪ Phần tử cần tìm có giá trị: 8
Method signature: int getMissingNumber(...)
 */
public class Ex02Array {
	public static int getMissingNumber(int[] A, int n) {
		int sumAll = n * (n + 1) / 2;
		int sumA = 0;

		for (int i = 0; i < A.length; i++) {
			sumA += A[i];
		}

		return sumAll - sumA;

	}

	public static void main(String[] args) {
		int[] A1 = { 3, 2, 1, 6, 5 };
		int n1 = 6;
		System.out.println("Phần tử cần tìm có giá trị: " + getMissingNumber(A1, n1));

		int[] A2 = { 3, 7, 9, 2, 1, 6, 5, 4, 10 };
		int n2 = 10;
		System.out.println("Phần tử cần tìm có giá trị: " + getMissingNumber(A2, n2));

	}
}
