package view;

import java.util.Scanner;

public class Ex04TryMultipleCatches {
	
	// Bài toán: 
	// Nhập vào tử/mẫu số. Thực hiện phép chia lấy phần nguyên
	
	// Khi có nhiều khối catch
	// - nếu các loại exception không có quan hệ cha con --> đặt trước/sau thoải mái
	// - nếu tồn tại các exception có quan hệ cha con
	//   . đặt exception con trước exception cha nếu xử lý riêng
	//   . xóa luôn exception con nếu muốn xử lý exception chung
	
	// Gộp chung block, loại exception khi chung logic xử lý bên trong khối catch
	// Khác xử lý bên khối catch --> tách catch block
	
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		try {
			System.out.print("Nhập vào tử số: ");
			int numerator = Integer.parseInt(ip.nextLine()); // NumberFormatException
			
			System.out.print("\nNhập vào mẫu số: ");
			int denominator = Integer.parseInt(ip.nextLine()); // NumberFormatException
			
			int result = numerator/denominator; // ArithmeticException
			
			System.out.print("\n==> Kết quả: " + result);
		} catch (ArithmeticException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
		ip.close();
	}
	
}
