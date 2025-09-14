package view;

import java.util.Scanner;


public class Exo5IoOperation {
	public static void main(String[] args) {
		
		// Scanner: hỗ trợ nhập xuất
		// nhập giá trị là chuỗi với netxLine
		// nhập giá trị ko phải là chuỗi netx...
		
		Scanner ip = new Scanner(System.in);
		
		System.out.print("nhập maMH");
		String id = ip.nextLine();
		
		System.out.print("nhập tenMH");
		String name = ip.nextLine();
		
		System.out.println("nhập số lượng");
		int amount = Integer.parseInt(ip.nextLine());
		
		System.out.println("nhập Mota");
		String description = ip.nextLine();
		
		System.out.printf("\nthông tin mặt hàng: %s", (id + "," + name) + "," + amount + "," + description);
		
		ip.close();
		
	}

}
