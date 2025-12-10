package view;

import java.util.Scanner;

public class Ex05IoOperation {
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhap MaMH: ");
		String id = ip.nextLine();
		
		System.out.println("Nhap TenMH: ");
		String	name = ip.nextLine();
		
		System.out.printf("Thông tin mặt hàng: %s", (id + " " + name));
	}

}
