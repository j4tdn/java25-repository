package view;

import bean.Book;
import bean.Textbook;
import bean.Referencebook;
import utils.Status;
import utils.Search;
import utils.CustomerBuy;

public class Ex05 {

	/*
			 Bài 5 (20đ):Viết chương trình mô phỏng việc mua bán sách giữa khách hàng và
		nhân viên trong cửa hàng A.
		Thông tin về các loại sách và khách hàng được mô tả như sau:
		▪ Khách hàng: Mã khách hàng, họ tên, số điện thoại, địa chỉ
		▪ Sách giáo khoa: Mã sách, đơn giá, nhà xuất bản, tình trạng (mới, cũ).
		▪ Sách tham khảo: Mã sách, đơn giá, nhà xuất bản, thuế %. Biết rằng:
		
		- Sách giáo khoa sẽ có mã sách bắt đầu là SGK
		- Sách tham khảo sẽ có mã sách bắt đầu là STK
		
		Thực hiện các yêu cầu sau:
		▪ Viết hàm tạo dữ liệu sách cho cửa hàng.
		- Tạo N đối tượng Sách Giáo Khoa
		- Tạo M đối tượng Sách Tham Khảo
		▪ Viết hàm thực hiện lần lượt các chức năng sau đây:
		▪ Tìm toàn bộ sách thuộc nhà xuất bản Nhi Đồng
		▪ Tìm toàn bộ sách có đơn giá nhỏ hơn 50
		▪ Tìm toàn bộ sách giáo khoa có đơn giá từ 100 đến 200
		▪ Khách hàng mua x cuốn sách giáo khoa, y cuốn sách tham khảo. Viết hàm
		tính tổng tiền mà khách hàng phải thanh toán. Biết rằng:
		- Sách giáo khoa - TextBook: Giảm 30% với sách cũ
		- Sách tham khảo - ReferBook: Thành tiền = đơn giá * (1 + %
		thuế)
	 */
	
	public static void main(String[] args) {
		input();
	}
	
	private static void input() {
		Book tb1 = new Textbook("SGK-01", 120, "Chi Pheo", Status.NEW); 
		Book tb2 = new Textbook("SGK-02", 150, "Nhi Dong", Status.OLD); 
		Book tb3 = new Textbook("SGK-03", 10, "Thi No", Status.NEW); 
		Book rb1 = new Referencebook("STK-01", 120, "Nhi Dong", 0.7); 
		Book rb2 = new Referencebook("STK-02", 30, "Hehe", 0.5); 
		Book rb3 = new Referencebook("STK-03", 110, "Hihi", 0.3); 
		
		
		Book[] listBook = new Book[6];
		listBook[0] = tb1;
		listBook[1] = tb2;
		listBook[2] = tb3;
		listBook[3] = rb1;
		listBook[4] = rb2;
		listBook[5] = rb3;
		
		System.out.println("\n========= NXB Nhi Dong=============\n");
		Search.searchPulisher(listBook, "Chi Pheo");
		
		System.out.println("\n========= Sach duoi 50=============\n");
		Search.searchPrice1(listBook);
		
		System.out.println("\n========= SGK tu 100-200=============\n");
		Search.searchPrice2(listBook);
		
		System.out.println("\n========= Thanh toan=============\n");
		Book[] listBuy = new Book[2];
		listBuy[0] = tb2;
		listBuy[1] = rb3;
		
		CustomerBuy.Buy(listBuy);
	}
}
