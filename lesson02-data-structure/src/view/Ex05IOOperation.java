package view;

import java.util.Scanner;

public class Ex05IOOperation {

	public static void main(String[] args) {
		
		// Scanner: hỗ trợ nhập xuất
		
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhập MaMH: ");
		String id = ip.nextLine();
		
		System.out.print("Nhập TenMH: ");
		String name = ip.nextLine();
		
		System.out.print("Nhập SoLuong: ");
		int amount = ip.nextInt();
		
		System.out.print("Nhập GiaBan: ");
		float salesPrice = Float.parseFloat(ip.nextLine());
		
		System.out.printf("Thông tin mặt hàng: %s", (id + ", " + name));
		
		ip.close();
		
	}
	
}
