package bai3;

import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập hàng: ");
		int row = Integer.parseInt(sc.nextLine());
		int[][] array = new int[row][row];
		for(int i=0;i<row;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0||j==i) {
					array[i][j]=1;
				}
				else {
					array[i][j]=array[i-1][j]+array[i-1][j-1];
				}
			}
		}
		for(int i = 0;i<row;i++) {
			for(int j = 0;j<=i;j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
}
