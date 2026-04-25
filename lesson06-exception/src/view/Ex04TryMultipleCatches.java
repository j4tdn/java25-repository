package view;

import java.util.Scanner;

public class Ex04TryMultipleCatches {
	
	// BÀi toán: nhập vào phần tử/ mẫu số
	// thự hiện phép chia phần nguyên
	
	//khi có nhiều khối catch
	//- nếu các loại exception không có quan hệ cha con --> đặt trước/sau thoải mái
	// .đặt exception con trước exception cha nếu xử lý riêng
	// . xóa luôn exception con nếu muốn xử lý exception chung
	
	//gộp chung block, loiaj exception khi chung logic xử lý bên tring khối catch
	// khác xử lý bên trong khối catch --> tách catch block
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		try {
		System.out.println("Nhập vào tử số: ");
		int numerator = Integer.parseInt(ip.nextLine()); //numeratorException
		
		System.out.println("\nNhập vào tử số: ");
		int denominator = Integer.parseInt(ip.nextLine());//NumberformatExxception
		
		int result = numerator/denominator;//ArithmeticExxceptio
		
		System.out.println("\nKết quả" + result);
		}
		catch(ArithmeticException | IllegalArgumentException e) {

			e.printStackTrace();
		
		}
		ip.close();
		
	}

}
