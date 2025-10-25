package assignments;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap hang: ");
		int n = Integer.parseInt(sc.nextLine());
		
		int [][]a = new int[n][n];
		for(int i = 0;i<n;++i) {
			for(int j = 0;j<=i;++j) {
				if(j==0||j==i) {
					a[i][j] = 1;
				}else {
					a[i][j] = a[i-1][j] + a[i-1][j-1];
				}
			}
		}
		for(int i = 0;i<n;++i) {
			for(int j = 0;j<=i;++j) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
}
