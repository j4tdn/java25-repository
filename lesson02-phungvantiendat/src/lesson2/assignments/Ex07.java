package lesson2.assignments;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		transform(n);
	}
	
	
	private static void transform(int n) {
		if(n > 1) {
			transform(n/2);
		}
		System.out.print(n%2);
	}
	

}
