package view;

import java.util.Scanner;

public class Ex05IoOperation {
	public static void main(String[] args) {
		//Scanner: hỗ trợ nhập xuất
		//Nhập giá trị là chuỗi với nextline :Nếu không nhập nhấn enter --> nhận giá trị rỗng
		//Nhập giá trị không phải là chuỗi với nextline:ít nhất phải nhập kí tự gì đó ->enter mới xử lý
		// nextline :
		//+ Nhập giá trị-> Enter -> Lẩy giá trị gán vẽ biến
		//+ Không nhap--> Enter-> Lây giá tri rỗng "" gán về biến
		//--> Kết thúc nhập Enter --> clear Enter khỏi vùng nhớ tam
		//!nextLine:
		// + Nhập giá trị --> Enter -> Lấy giá trí gán về biến
		// + Không nhập--> Enter -> Không làm gì cả
		// --> Kết thúc nhập Enter --> Không clear Enter khói vùng nhớ tạm
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhập MaMH: ");
		String id =  ip.nextLine();
		
		System.out.print("Nhập TenMH: ");
		String name =  ip.nextLine();//nextInt,nextDouble

		System.out.print("Nhập TenMH: ");
		int amount =  Integer.parseInt(ip.nextLine());
		
		System.out.print("Nhập TenMH: ");
		float salesPrice =  Float.parseFloat(ip.nextLine());

		System.out.print("Nhập TenMH: ");
		String description =  ip.nextLine();
		
		System.out.printf("Thông tin mặt hàng: %s",(id + "," + name + "," + amount + "," + salesPrice + "," + description));
		
		ip.close();
	}
}
