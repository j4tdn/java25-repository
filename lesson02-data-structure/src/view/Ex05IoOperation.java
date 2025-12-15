package view;

import java.util.Scanner;

public class Ex05IoOperation {
	
	public static void main(String[] args) {
		// Scanner: Hỗ trợ nhập xuất

		// nextLine :
		// + Nhập giá trị --> Enter -> Lấy giá trị gán về biến
		// + Không nhập   --> Enter -> Lấy giá trị rỗng "" gán về biến
		// --> Kết thúc nhập Enter --> clear Enter khỏi vùng nhớ tạm
		
		// !nextLine:
		// + Nhập giá trị --> Enter -> Lấy giá trị gán về biến
		// + Không nhập   --> Enter -> Không làm gì cả
		// --> Kết thúc nhập Enter --> Không clear Enter khỏi vùng nhớ tạm
		
		
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhập MaMH: ");
		String id = ip.nextLine();
		
		System.out.print("Nhập TenMH: ");
		String name = ip.nextLine(); // nextInt, nextDouble
		
		System.out.print("Nhập SoLuong: ");
		// int amount = Integer.parseInt(ip.nextLine());
		int amount = ip.nextInt();
		
		System.out.print("Nhập GiaBan: ");
		float salesPrice = Float.parseFloat(ip.nextLine());
		// float salesPrice = ip.nextFloat();
		// ip.nextLine();
		
		System.out.print("Nhập MoTa: ");
		String description = ip.nextLine();
		
		System.out.printf("\nThông tin mặt hàng: %s", (id + ", " + name + ", " + amount + ", " + salesPrice + ", " + description));

		ip.close();
	}
	
}