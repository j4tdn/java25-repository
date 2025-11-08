package utils;

import bean.Book;

public class CustomerBuy {
	/*
	 ▪ Khách hàng mua x cuốn sách giáo khoa, y cuốn sách tham khảo. Viết hàm
			tính tổng tiền mà khách hàng phải thanh toán. Biết rằng:
			- Sách giáo khoa - TextBook: Giảm 30% với sách cũ
			- Sách tham khảo - ReferBook: Thành tiền = đơn giá * (1 + %
			thuế)
	 */
	public CustomerBuy() {
	
	}
	
	public static double Buy(Book[] listBuy) {
		double total = 0;
		for(Book book: listBuy) {
			total += book.pay();
		}
		System.out.println(total);
		return total;
	}
}
