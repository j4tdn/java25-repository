package lesson10_array;

public class Ex01 {
	public class Main {
	    public static void main(String[] args) {

	        int[][] matrix = {
	            {1, 2, 3, 4},
	            {5, 6, 8, 7},
	            {1, 9, 0, 9},
	            {2, 9, 6, 5},
	            {1, 2, 4, 5}
	        };

	        int zeroRow = -1;
	        int zeroCol = -1;


	        for (int i = 0; i < matrix.length; i++) {
	            for (int j = 0; j < matrix[i].length; j++) {
	                if (matrix[i][j] == 0) {
	                    zeroRow = i;
	                    zeroCol = j;
	                }
	            }
	        }

	        
	        for (int j = 0; j < matrix[0].length; j++) {
	            matrix[zeroRow][j] = 0;
	        }

	      
	        for (int i = 0; i < matrix.length; i++) {
	            matrix[i][zeroCol] = 0;
	        }

	       
	        for (int[] row : matrix) {
	            for (int val : row) {
	                System.out.print(val + " ");
	            }
	            System.out.println();
	        }
	    }
	}
}
