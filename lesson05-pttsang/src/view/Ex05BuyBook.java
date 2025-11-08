package view;

import bean.Book;
import bean.ReferBook;
import bean.TextBook;

/*
 Viết chương trình mô phỏng việc mua bán sách giữa khách hàng và nhân viên trong cửa hàng A.
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
▪ Viết hàm thực hiện lần lượt các chức năng sau đây:                                                 SGK01,40, Nhi Đồng, mới
                                                                                                     STK01, 30, Nhi Đồng, 0.1
▪ Tìm toàn bộ sách thuộc nhà xuất bản Nhi Đồng => NXB
▪ Tìm toàn bộ sách có đơn giá nhỏ hơn 50 => price
▪ Tìm toàn bộ sách giáo khoa có đơn giá từ 100 đến 200
▪ Khách hàng mua x cuốn sách giáo khoa, y cuốn sách tham khảo. Viết hàm
tính tổng tiền mà khách hàng phải thanh toán. Biết rằng:
- Sách giáo khoa - TextBook: Giảm 30% với sách cũ
- Sách tham khảo - ReferBook: Thành tiền = đơn giá * (1 + %
thuế)
 */

public class Ex05BuyBook {
	public static void main(String[] args) {
		Book tb1 = new TextBook("SGK01", 40d, "Nhi Đồng", "Mới");
		Book tb2 = new TextBook("SGK02", 110d, "Nhi Đồng", "Cũ");
		Book tb3 = new TextBook("SGK03", 60d, "Tiền Phong", "Mới");

		Book rb1 = new ReferBook("STK01", 30d, "Nhi Đồng", 0.1d);
		Book rb2 = new ReferBook("STK02", 55d, "Tiền Phong", 0.05d);

		Book[] books = { tb1, tb2, tb3, rb1, rb2 };

		for (Book b : books) {
			System.out.println(b);
		}

	} // ...

}
