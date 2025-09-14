package homework;

import java.util.Scanner;

public class BT7 {
  
		/*
		 * Bài 7: Viết chương trình chuyển đổi cơ số một số tự nhiên ở hệ cơ số 10(thập phân) thành số ở hệ
	cơ số 2(nhị phân)
	Tham khảo công thức: https://bit.ly/3QuVyXx
	VD: Nhập N = 0 → 0
	N = 1 → 1
	N = 2 → 10
	N = 3 → 11
	N = 4 → 100
	N = 5 → 101
	
		 */
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.print("Nhập số tự nhiên: ");
		int m = sc.nextInt();
		
		System.out.println("Hệ nhị phân của " +m +"là: "+transform(m)); // BÀI 7 SAI R
	}

	private static int transform(int n) {
		int a=0;
		while(n>0) {
			a =a*10+n%2;
			n=n/2;
		}
		return a;
	}
	
}
