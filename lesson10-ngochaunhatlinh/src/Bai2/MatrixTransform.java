package Bai2;

public class MatrixTransform {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 8, 7},
            {1, 9, 0, 9},
            {2, 9, 6, 5},
            {1, 2, 4, 5}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        int zeroRow = -1, zeroCol = -1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRow = i;
                    zeroCol = j;
                    break;
                }
            }
        }

        for (int j = 0; j < cols; j++) {
            matrix[zeroRow][j] = 0;
        }

        for (int i = 0; i < rows; i++) {
            matrix[i][zeroCol] = 0;
        }
       
        System.out.println("Ma trận sau khi chuyển đổi:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
