/*
 * Bài 3 (20đ): Cho mảng A gồm n phần tử (2 < n < 20). Ak € [1, 10]
Tìm bội chung nhỏ nhất của các phần tử trong mảng
▪ VD1: A = [2, 3] → BCNN = 6
▪ VD2: A = [2, 3, 4] → BCNN = 12
Method signature: int getLeastCommonMultiple(....)
 */
public class Ex03LeastCommonMultiple {
	public static int getLeastCommonMultiple(int[] A) {
		int result = A[0];

		for (int i = 1; i < A.length; i++) {
			int max = Math.max(result, A[i]);

			while (true) {

				if (max % result == 0 && max % A[i] == 0) {
					result = max;
					break;
				}
				max++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] A1 = { 2, 3 };
		System.out.println("BCNN = " + getLeastCommonMultiple(A1));

		int[] A2 = { 2, 3, 4 };
		System.out.println("BCNN = " + getLeastCommonMultiple(A2));

	}
}