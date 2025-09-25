package horse_saddle;

public class IsHorseBuddle {
	public IsHorseBuddle() {
		
	}
	
	public static void maxColumn(int[][] matrix, int row, int column) {
		int count = 0;
		for(int i = 0; i < row; i++) {
			int minValRow = matrix[i][0];
			int indexColMin = 0;
			for(int j = 1; j < column; j++) {
				if(matrix[i][j] < minValRow) {
					minValRow = matrix[i][j];
					indexColMin = j;
				}
			}
			boolean isHorseBuddle = true;
			for(int k = 0; k < row; k++) {
				if(matrix[k][indexColMin] > minValRow) {
					isHorseBuddle = false;
					break;
				}
			}
			if(isHorseBuddle) { 
				System.out.printf("Gia tri yen ngua tai [%d][%d] la: %d\n",
					i + 1, indexColMin + 1, minValRow);
				count++;
			}
		}
		if(count == 0) {
			System.out.println("Khong tim thay");
		}
	}
}
