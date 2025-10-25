package inheritance.cclass;

import java.math.BigDecimal;

public class InheritanceParentClassDemo {
	/*
	  Giải lập bài toán về quản lý sách ở văn phòng phẩm
		Sách giáo khoa: mã sách, tên sách, giá bán, tình trạng (cũ mới), phần trăm giảm giá
		Sách tham khảo: mã sách, tên sách, giá bán, thuế xuất bản
		
	Yêu cầu:

	1. Tạo N đối tượng SGK, STK
	2. Tìm những cuốn sách là SGK cũ có % giảm giá > 2%
	 
	 Book : id, name, salesPrice
	 TextBook extends Book
	 --> status, discountInPercent
	 
	 ReferenceBook extends Book
	 --> tax
	 */
	public static void main(String[] args) {
		Book[] books = mocData();
		
		System.out.println("--- Danh sách tất cả sách ---");
		for (Book book : books) {
			if(book.isMatchedForSales()) {
				System.out.println(book);
			}
		}
	}
	
	private static Book[] mocData() {
		return new Book[] {
				new TextBook("SGK-1", "Toan", bd("220"), Status.NEW, BigDecimal.ZERO),
				new TextBook("SGK-2", "Lich Su", bd("180"), Status.OLD, bd("1")),
				new TextBook("SGK-3", "Khoa Hoc Tu Nhien", bd("220"), Status.OLD, bd("5")),
				new TextBook("SGK-4", "My Thuat", bd("82"), Status.NEW, BigDecimal.ZERO),
				
				new ReferenceBook("STK-1", "Vat Ly TK", bd("440"), bd("4")),
				new ReferenceBook("STK-2", "Sinh hoc TK", bd("510"), bd("1")),
				new ReferenceBook("STK-3", "Hoa Hoc TK", bd("480"), bd("6")),
		};
	}
	private static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}
}
