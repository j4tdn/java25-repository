package inheritance.cclass;

import java.math.BigDecimal;

public class InheritanceParentClassDemo {
	
	/*
	 Giải lập bài toán về quản lý sách ở văn phòng phẩm
	 
	 Sách giáo khoa: mã sách, tên sách, giá bán, tình trạng(cũ mới), phần trăm giảm giá
	 Sách tham khảo: mã sách, tên sách, giá bán, thuế xuất bản
	 
	 Yêu cầu:
	 1. Tạo N đối tượng SGK, STK
	 2. Tìm những cuốn sách là SGK cũ có % giảm giá > 2% và STK có thuế > 3%
	 
	 Book: id, name, salesPrice
	 
	 TextBook extends Book
	 --> status, discountInPercent
	 
	 ReferenceBook extends Book
	 --> tax
	 */
	
	public static void main(String[] args) {
		// Tìm những cuốn sách là SGK cũ có % giảm giá > 2% và STK có thuế > 3%
		Book[] books = mockData();
		for (Book book: books) {
			if (book.isMatchedForSales()) {
				System.out.println(book);
			}
		}
	}
	
	private static Book[] mockData() {
		return new Book[] {
			new TextBook("SGK-1", "Toán", bd("220"), Status.NEW, BigDecimal.ZERO),
			new TextBook("SGK-2", "Lịch Sử", bd("180"), Status.OLD, bd("1")),
			new TextBook("SGK-3", "Khoa học tự nhiên", bd("520"), Status.OLD, bd("5")),
			new TextBook("SGK-4", "Mỹ thuật", bd("82"), Status.NEW, BigDecimal.ZERO),
			
			new ReferenceBook("STK-5", "Vật lý TK", bd("440"), bd("4")),
			new ReferenceBook("STK-6", "Sinh học TK", bd("510"), bd("1")),
			new ReferenceBook("STK-7", "Hóa học TK", bd("480"), bd("6")),
		};
	}
	
	private static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}
	
}
