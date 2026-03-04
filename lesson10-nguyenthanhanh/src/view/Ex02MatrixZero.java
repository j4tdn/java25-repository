package view;

public class Ex02MatrixZero {

	public static void main(String[] args) {
		
		int[][] matrix = {
				{1, 2, 3, 4},
				{5, 0, 8, 7},
				{1, 9, 0, 9},
				{2, 0, 6, 5},
				{1, 2, 4, 5}
		};
		
		System.out.println("Mảng gốc -------->");
		print(matrix);
		
		convertToMatrixZero(matrix);
		System.out.println("Mảng sau khi convert -------->");
		print(matrix);
		
	}
	
	private static void convertToMatrixZero(int[][] matrix) {
		
		if(matrix.length == 0) {
			return;
		}
		
		boolean[] rowMarker = new boolean[matrix.length];
		boolean[] colMarker = new boolean[matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					rowMarker[i] = true;
					colMarker[j] = true;
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(rowMarker[i] || colMarker[j]) {
					matrix[i][j] = 0;
				}
			}
		}
		
	}
	
	private static void print(int[][] matrix) {
		for (int[] row : matrix) {
            for (int val : row) {
                System.out.print("   " + val);
            }
            System.out.println();
        }
	}
	
}
