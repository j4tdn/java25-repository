package view;

import java.util.Scanner;

public class Ex04TryMultipleCatches {

	//Bài toán: Nhập vào tử/mẫu 
	// Thực hiện phép chia lấy phần nguyên
	
	//Khi co nhiều khối catch
	//-nêý các loại exception ko có quan hệ cha con --> đặt trước đặt sau thoải mái 
	//	. Đặt exception con trước exception cha nếu xử lí riêng
	//	. xoá luôn exception con nếu muốn xử lí exception chung 
	
	// Gọp chung block , loại exception khi chung logic xử lí bên trong khối catch
	// Khác xử lí bên khôi catch --> tách catch block 
	
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		try {
			System.out.println("Nhập vào tử số: ");
			int numerator = Integer.parseInt(ip.nextLine());	//numberFormatException
			
			System.out.println("Nhập vào mẫu số: ");
			int denomiator = Integer.parseInt(ip.nextLine());	//numberFormatException
			
			int result = numerator/denomiator;	//ArithmeticException
			
			System.out.println("Kêt quả: "+result);
//		} catch (NumberFormatException nfe) {
//			System.out.println(">>nfe "+nfe.getMessage());
//		}catch (ArithmeticException ae) {
//			System.out.println(">>ae "+ae.getMessage());
//		}catch(IllegalArgumentException iae) {
//			System.out.println(">>iae "+iae.getMessage());
		}catch (ArithmeticException | IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		ip.close();
		
	}

}
