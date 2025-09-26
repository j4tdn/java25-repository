package ex03saddlepoint;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		System.out.println("nhập số hàng M:");
		int m = sc.nextInt();
		System.out.println("nhập số hàng n:");
		int n = sc.nextInt();
		
		Matrix matrix = new Matrix();
		matrix.setRows(m);
		matrix.setCols(n);
		matrix.setData(new int [m][n]);
		
		MatrixUntils matrixUntils = new MatrixUntils();
		
		matrixUntils.intput(matrix);
		matrixUntils.output(matrix);
		matrixUntils.saddlePoint(matrix);
	}
}
