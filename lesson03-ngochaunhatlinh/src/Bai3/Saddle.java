package Bai3;

import java.util.Scanner;

public class Saddle {
	static int M, N;
	static int[][] a;
	public static void main(String[] args) {
		input();
		output();
	}
	public static void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap dòng M: ");
		 M =sc.nextInt();
		System.out.println("Nhap dong N: ");
		 N = sc.nextInt();
		 a = new int[M][N];
		
		System.out.println("Nhap co ptu trong Yen ngua MxN: ");
		for(int i =0; i<M; i++) {
			for(int j =0; j<N; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
	}
	public static void output() {
		for(int i =0; i<M; i++) {
			int min = a[i][0];
			int colum = 0;
			for(int j =1; j<N; j++) {
				if(a[i][j] < min) {
					min = a[i][j];
					colum =j;
				}
			}
			if(isCheck(i, colum)) {
				System.out.println("ptu yen ngua la: " + "A[" + i + "]" +"[" + colum + "]");
			}else {
				System.out.println("kh có ptu yen ngua nao");
			}
		}
	}
	public static boolean isCheck(int d, int c) {
		int value = a[d][c];
		for(int i =0; i<M; i++) {   
			if(a[i][c] > value) {
				return false;
			}
		}
		return true;
	}
}
