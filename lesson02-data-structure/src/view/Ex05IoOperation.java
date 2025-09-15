package view;

import java.util.Scanner;

public class Ex05IoOperation {
	public static void main(String[] args) {
		// Scanner hỗ trợ nhập xuất
		// Nhập giá trị là chuối sử dụng nextLine():Nếu không nhập ký tự thì nhận về giá
		// trị rỗng
		// int,float,double tùy cơ ứng biến tương tự.:Ít nhất là phải nhập ký tự gì đó

		// => Đối với nextLine() khi nhập xong enter nó sẽ xóa enter khỏi vùng nhớ tạm
		// và duy chuyển đến câu lệnh tiếp theo
		// ==> Đối với !nextLine() khi nhập xong nó không xóa enter khỏi vùng nhớ tạm
		// làm cho câu lệnh nhập xuất tiếp theo bị dư phím inter
		// ==> Giải pháp là dùng cách ép kiểu Integer.parseInt hoặc float hoặc double
		// đối với những lệnh nhập khác nextLine().
		Scanner ip = new Scanner(System.in);
		System.out.printf("Mã mặt hàng: ");
		int id = Integer.parseInt(ip.nextLine());
		System.out.printf("Nhập số lượng: ");
		int amout = Integer.parseInt(ip.nextLine());
		System.out.printf("Nhập mô tả: ");
		String des = ip.nextLine();
		System.out.printf("Nhập tên mặt hàng: ");
		String name = ip.nextLine();
		System.out.printf("\nThông tin mặt hàng: %s", (id + "," + name + "," + amout + "," + des));
		ip.close();
	}

}
