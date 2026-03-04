package Ex02;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 0, 8, 7},
                {1, 9, 0, 9},
                {2, 0, 6, 5},
                {1, 2, 4, 5}
        };

        zeroMatrix(matrix);
        printMatrix(matrix);
    }

    public static void zeroMatrix(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;

        boolean[] zeroRow = new boolean[rows];
        boolean[] zeroCol = new boolean[cols];

        // B1: đánh dấu hàng & cột có 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (a[i][j] == 0) {
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }

        // B2: set 0 cho hàng
        for (int i = 0; i < rows; i++) {
            if (zeroRow[i]) {
                for (int j = 0; j < cols; j++) {
                    a[i][j] = 0;
                }
            }
        }

        // B3: set 0 cho cột
        for (int j = 0; j < cols; j++) {
            if (zeroCol[j]) {
                for (int i = 0; i < rows; i++) {
                    a[i][j] = 0;
                }
            }
        }
    }

    public static void printMatrix(int[][] a) {
        for (int[] row : a) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}