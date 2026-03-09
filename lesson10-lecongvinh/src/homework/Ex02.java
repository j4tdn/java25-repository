package homework;

public class Ex02 {
	public static void main(String[] args) {
		int[][] a = {
			    {1, 2, 3, 4},
			    {5, 6, 8, 7},
			    {1, 9, 0, 9},
			    {2, 9, 6, 5},
			    {1, 2, 4, 5}
			};
		
		int col = 0;
		int row = 0;
		
		for(int i = 0;i < a.length;i++) {
			for(int j = 0;j < a[i].length;j++) {
				if(a[i][j] == 0) {
					col = i;
					row = j;
					break;
				}
			}
		}
		
		for(int i = 0;i < a.length;i++) {
			a[i][col] = 0;
		}
		
		for(int i = 0;i < a[row].length;i++) {
			a[row][i] = 0;
		}

		for(int i = 0;i < a.length;i++) {
			for(int j = 0;j < a[i].length;++j) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
