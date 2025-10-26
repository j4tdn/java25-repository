package inheritance;

import java.math.BigDecimal;

public class InheritanceParentClassDemo {
	/*
	 * Giải bài tập về quản lí sách ở văn phòng phẩm
	 * Sách giáo khoa : mã sách, tên sách,giá banms, tình trạng(cũ mới), phần trăm giảm giá 
	 * Sách tham khảo: mã sách, tên sách,giá banms, tình trạng(cũ mới),thuế xuất bản 
	 * Yêu cầu : 
	 *- Tạo N đối trượng sgk, stk
	 *- Tìm những cuốn sách là SGK cũ có % giảm giá >2%
	 *Book: id, name, salesPrice
     TextBook extends Book
     -→> status, discountInPercent
     ReferenceBook extends Book
     --> tax
	 */
	public static void main(String[] args) {
		
	}
	private static Book[] mockData() {
		return new Book[] {
				new TextBook("SGK-1","Toan",bd("220"),Status.NEW,null)
		};
	}
	private static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}
}
