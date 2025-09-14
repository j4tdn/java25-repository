package view;

import java.util.Scanner;

public class Ex05IoOperation {
	public static void main(String[] args) {
		// Scanner: Ho tro nhap xuat
		// Nhap gia tri la chuoi voi nẽt line: neu k nhap nhan enter --> nhan gia tri rong
		// Nhap gia tri k phai la chuoi next...: it nhat phai nhap ki tu gi do --> enter moi xu ly
		
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhập mã mặt hàng: ");
		String id = ip.nextLine();
		
		System.out.print("Nhập tên mặt hàng: ");
		String name = ip.nextLine();
		
		System.out.println("Nhập số lượng: ");
		int amount = Integer.parseInt(ip.nextLine());
		
		System.out.print("Nhập mô tả mặt hàng: ");
		String des = ip.nextLine();
		
		System.out.printf("Thông tin mặt hàng: %s", (id + ", " + name + ", " + amount + ", " + des));
		
//		System.out.println("Ket thuc");
		
		ip.close();
	}
}
