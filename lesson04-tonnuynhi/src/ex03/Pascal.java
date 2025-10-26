package ex03;

public class Pascal {

	public static void printPascalTriangle(int rows) {
		if (rows <= 0) {
			System.out.println("Số hàng phải lớn hơn 0.");
			return;
		}

		System.out.println("--- Tam giác Pascal (" + rows + " hàng) ---");

		int[] previousRow = {};

		for (int n = 1; n <= rows; n++) {

			int[] currentRow = new int[n];

			for (int k = 0; k < n; k++) {

				if (k == 0 || k == n - 1) {
					currentRow[k] = 1;
				} else {
					currentRow[k] = previousRow[k - 1] + previousRow[k];
				}
			}

			for (int num : currentRow) {
				System.out.print(num + " ");
			}
			System.out.println();

			previousRow = currentRow;
		}
	}

	public static void main(String[] args) {
		printPascalTriangle(6);
	}
}