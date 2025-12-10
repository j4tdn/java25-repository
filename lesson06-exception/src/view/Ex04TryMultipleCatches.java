package view;

import java.util.Scanner;

public class Ex04TryMultipleCatches {
	
	// Bài toán:
	// Nhập vào tử/ mẫu số. thực hiện phép chia lấy phần nguyên
	
	//khi có nhiều khối catch
	// - nếu các loại exception có quan hệ cha con
	// 	. đặt exception con trước exception cha nếu xử lý riêng
	//	. xóa luôn exception con nếu muốn xử lý exception chung
	
	// Ghộp chung block, loại exception khi chung logic xử lý bên trong khối catch
	// khác xử lý bên khối catch --> tách catch block
	
	public static void main(String[] args) {
	
		Scanner ip = new Scanner(System.in);
		
		try {
			System.out.print("Nhap vao tu so: ");
			int numerator = Integer.parseInt(ip.nextLine());//NumberFormatException
			
			System.out.print("Nhap vao mau so: ");
			int denominator = Integer.parseInt(ip.nextLine()); //NumberFormatException
			
			int result = numerator/denominator; // ArithmeticException
			
			System.out.print("ker qua: " + result);
		} catch (ArithmeticException | IllegalArgumentException e) {
			//System.out.println(">> " + e.getMessage());
			e.printStackTrace();
		} 
		
		ip.close();
		
	}

}
