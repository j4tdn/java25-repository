package assignments;

public class Ex02 {

	public static void main(String[] args) {
		int[][] arr = {
			    {1, 2, 3, 4},
			    {5, 6, 8, 7},
			    {1, 9, 0, 9},
			    {2, 9, 6, 5},
			    {1, 2, 4, 5}
			};
		
		int colIndex = 0;
		int rowIndex = 0;
		
		for(int i = 0;i<arr.length;++i) {
			for(int j = 0;j<arr[i].length;++j) {
				if(arr[i][j] == 0) {
					colIndex = i;
					rowIndex = j;
					break;
				}
			}
		}
		
		for(int i = rowIndex;i<4;++i) {
			for(int j = colIndex;j<4;++j) {
				
			}
		}
		
	}

}
