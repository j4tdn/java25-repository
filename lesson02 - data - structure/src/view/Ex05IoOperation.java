package view;

import java.util.Scanner;

public class Ex05IoOperation {

	public static void main(String[] args) {
		//Scanner: hỗ trợ nhập xuất
		// Nhập giá trị là chuỗi với nextLine   :nếu k nhập nhấn Enter --> nhận giá trị rỗng
		// Nhập giá trị k phải là chuỗi next... : ít nhất phải nhập kí tự gì đó -> Enter mới xử lý 
		
		/* nextLine:
		 *  + Nhập giá trị --> Enter -> Lấy giá trị gán về biến
		 *  + Không nhập ---> Enter -> Lấy giá trị rỗng gán về biến
		 *   --> Kết thúc nhập Enter --> clear Enter khỏi vùng nhớ tạm
		 *   
		 *  !nextLine:
		 *  + Nhập giá trị --> Enter -> lấy giá trị gán về biến 
		 *  + Không nhập --> Enter -> Không làm gì cả
		 *  --> Kết thúc nhập Enter --> Không clear Enter khỏi vùng nhớ tạm
		 *  
		 */
		
		
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Nhập MaMH: ");
		String id = ip.nextLine();
		
		System.out.print("Nhập TenMH: ");
		String name = ip.nextLine();

		System.out.print("Nhập SoLuong: ");
		int amount = Integer.parseInt(ip.nextLine());
		System.out.print("Nhập Mota: ");
		String description = ip.nextLine();
		
		System.out.printf("Thông tin mặt hàng:  %s",(id +", "+name + ", "+amount+", " + description));
		
		ip.close();
	}
	
}
