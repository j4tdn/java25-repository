package horse_saddle;

import java.util.Random;

public class InsertRowColumn {
	
	public InsertRowColumn() {
		
	}
	
	public static int[][] insert(int row, int column){
		
	Random rd = new Random();
	int[][] matrix = new int[row][column];
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				matrix[i][j] = rd.nextInt(100);
			}
		}
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				System.out.print( matrix[i][j] + "   ");
			}
			System.out.println("\n");
		}
		return matrix;
	}
}
