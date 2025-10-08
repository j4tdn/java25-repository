package view;

import java.util.Arrays;

public class Ex03SaddlePoint {

	public static void main(String[] args) {
		// Mảng 2 chiều
		// Số hàng: 3 (3 mảng 1 chiều, 3 phần tử của mảng 2 chiều)
		// Số cột: 4 cột
		int[][] a2D = { { 47, 47, 36, 42 }, { 23, 43, 31, 27 }, { 46, 7, 29, 19 } };

		System.out.println("Matrix a2D");
		System.out.println("===========");
		printA2D(a2D);

		System.out.println("\n\n");
		System.out.println("===> Saddle Point: " + getSaddlePoint(a2D));
	}

	private static Integer getSaddlePoint(int[][] a2D) {
		for (int rowI = 0; rowI < a2D.length; rowI++) {
			int minRow = Integer.MAX_VALUE;
			int minRowColIndex = -1; 
			for (int colI = 0; colI < a2D[rowI].length; colI++) {
				if (a2D[rowI][colI] < minRow) {
					minRow = a2D[rowI][colI];
					minRowColIndex = colI;
				}
			}
			
			// Duyệt các phần tử trong cột minRowColIndex
			if (isMaxCol(minRow, minRowColIndex, a2D)) {
				return minRow;
			}
			
		}
		return null;
	}
	
	private static boolean isMaxCol(int element, int columnIndex, int[][] a2D) {
		int rowsLength = a2D.length;
		for (int i = 0; i < rowsLength; i++) {
			if (a2D[i][columnIndex] > element) {
				return false;
			}
		}
		return true;
	}

	private static void printA2D(int[][] a2D) {
		for (int rowI = 0; rowI < a2D.length; rowI++) {
			for (int colI = 0; colI < a2D[rowI].length; colI++) {
				int element = a2D[rowI][colI];
				int elementLength = String.valueOf(element).length();
				String space = elementLength == 1 ? "  " : " ";
				System.out.print(element + space);
			}
			System.out.println();
		}
	}
}
