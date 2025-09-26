package ex03saddlepoint;

import java.util.Arrays;

public class Matrix {
	private int rows;
	private int cols;
	private int [][] data;
	
	public Matrix() {
	}

	public Matrix(int rows, int cols, int[][] data) {
		this.rows = rows;
		this.cols = cols;
		this.data = data;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int[][] getData() {
		return data;
	}

	public void setData(int[][] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Matrix [rows=" + rows + ", cols=" + cols + ", data=" + Arrays.toString(data) + "]";
	}
	
}
