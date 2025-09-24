package homework;

import java.util.Scanner;

import util.NumberUtils;

public class Ex03PhanTuYenNgua {

	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		int[][] matrix = enterNumbersOfMatrix(ip, 3, 3);
		
		printMatrix(matrix);
		
		System.out.println("Phần tử yên ngựa là " + findRetreatElement(matrix));
		
	}
	
	private static Integer findRetreatElement(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				int element = matrix[i][j];
				if(isMaxCol(element, j, matrix) && isMaxRow(element, matrix[i])) {
					return element;
				}
			}
		}		
		return null;
	}
	
	private static boolean isMaxRow(int checkingElement, int[] elements) {
		for(int i = 0; i < elements.length; i++) {
			int element = elements[i];
			if(element < checkingElement) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean isMaxCol(int checkingElement,int colI,int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			int element = matrix[i][colI];
			if(element > checkingElement) {
				return false;
			}
		}
		return true;
	}
	
	private static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%d",matrix[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
	}
	
	private static int[][] enterNumbersOfMatrix(Scanner ip,int n, int m) {
		int[][] matrix = new int[n][m];
		String text = null;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m;) {
				System.out.printf("Nhập N[%d][%d] = ",i,j);
				text = ip.nextLine();
				if(NumberUtils.isValidNumber(text)) {					
					matrix[i][j] = Integer.parseInt(text);
					j++;
				}
			}
		}
		return matrix;
	}
	
}
