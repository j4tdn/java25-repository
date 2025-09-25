package horse_saddle;

import java.util.Scanner;

public class Ex03HorseSaddle {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nhap so cot: ");
		int row = sc.nextInt();
		
		System.out.println("Nhap so hang: ");
		int column = sc.nextInt();
		
		IsHorseBuddle.maxColumn(InsertRowColumn.insert(row, column), row, column);
		
		sc.close();
	}
}
