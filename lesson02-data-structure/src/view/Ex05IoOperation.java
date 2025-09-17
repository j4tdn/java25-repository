package view;

import java.util.Scanner;

public class Ex05IoOperation {
	public static void main(String[] args) {
		
		
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập MaMH:");
		String id = ip.nextLine();
		
		System.out.print("Nhap TenMH:");
		String name = ip.nextLine();
		
		System.out.println("Nhao soLuong: ");
		int amount = Integer.parseInt(ip.nextLine());
		
		System.out.printf("Thong tin mat hang: %s", (id + ", " + name + ", " + amount  ));
		
		ip.close();
		
	}	
}
