package inheritance.cclass;

import java.math.BigDecimal;

public class inheritanceParentClassDemo {

	/*
	 * 
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
					new TextBook ("SGK-1","Toán",bd("220"),Status.NEW,BigDecimal.ZERO),
					new TextBook ("SGK-2","Lịch Sử",bd("180"),Status.OLD,BigDecimal.ZERO),
					new TextBook ("SGK-3","khoa học tự nhiên",bd("520"),Status.OLD,bd("5")),
					new TextBook ("SGK-4","Mỹ thuật",bd("82"),Status.NEW,BigDecimal.ZERO),
					
					
					new ReferrenceBook ("STK-1","Vật lý TK",bd("440"),bd("4")),
					new ReferrenceBook ("STK-2","Sinh học TK",bd("510"),bd("1")),
					new ReferrenceBook ("STK-3","Vật lý TK",bd("480"),bd("6")),
		};
	}
	private static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}
	
}
