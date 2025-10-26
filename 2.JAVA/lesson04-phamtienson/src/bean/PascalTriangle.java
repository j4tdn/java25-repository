package bean;

public class PascalTriangle {
	 private int[][] triangle;
	    
	    public PascalTriangle(int depth) {
	        this.triangle = generatePascalTriangle(depth);
	    }
	    
	    private int[][] generatePascalTriangle(int depth) {
	        int[][] result = new int[depth][depth];
	        
	        for (int i = 0; i < depth; i++) {
	            for (int j = 0; j <= i; j++) {
	                if (j == 0 || j == i) {
	                    result[i][j] = 1;
	                } else {
	                    result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
	                }
	            }
	        }
	        
	        return result;
	    }
	    
	    public int getValueAt(int row, int column) {
	        return triangle[row][column];
	    }
	    
	    public void printTriangle() {
	        for (int i = 0; i < triangle.length; i++) {
	            for (int j = 0; j <= i; j++) {
	                System.out.print(triangle[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
}