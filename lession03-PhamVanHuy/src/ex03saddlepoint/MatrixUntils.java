package ex03saddlepoint;

import java.util.Scanner;

public class MatrixUntils {
	public void intput(Matrix matrix) {
		Scanner sc = new Scanner(System.in);
		int[][] data = new int[matrix.getRows()][matrix.getCols()];
		System.out.println("Nhập ma trận" + matrix.getRows() + "x" + matrix.getCols() + ":");
		for(int i = 0; i < matrix.getRows(); i++) {
			for(int j = 0; j < matrix.getCols(); j++) {
				System.out.println("A[" + i + "][" + j +"] =");
				data[i][j] = sc.nextInt();
			}
		}
		matrix.setData(data);
	}
	public void output(Matrix matrix) {
		System.out.println("\nMa trận:");
		int[][] data = matrix.getData();
		for(int i = 0; i < matrix.getRows(); i++) {
			for(int j = 0; j < matrix.getCols(); j++) {
				System.out.print(data[i][j] + "\t");
			}
			System.out.println();
		}
	}
	public void saddlePoint(Matrix matrix) {
		boolean found = false;
		int[][] data = matrix.getData();
		int rows = matrix.getRows();
		int cols = matrix.getCols();
		
		int[] minRow = new int [rows];
		for(int i = 0; i < rows; i++) {
			minRow[i] = data[i][0];
			for(int j = 1; j < cols; j++) {
				if(data[i][j] < minRow[i]) {
					minRow[i] = data[i][j]; 
				}
			}
		}
		int[] maxCol = new int [cols];
		for(int j = 0; j < cols; j++) {
			maxCol[j] = data[0][j];
			for(int i = 1; i < rows; i++) {
				if(data[i][j] > maxCol[j]) {
					maxCol[j] = data[i][j]; 
				}
			}
		}
		for(int i = 0;i < rows;i++) {
			for(int j = 0; j<cols; j++) {
				if(data[i][j] == minRow[i] && data[i][j] == maxCol[j]) {
					System.out.println("phần tử yên ngựa : A[" + i +"][" + j + "] ="  + data[i][j]);
					found = true;
				}
			}
		}
		if(!found) {
			System.out.println("không có phần tử yên ngựa nào trong ma trận");
		}
	}
}
