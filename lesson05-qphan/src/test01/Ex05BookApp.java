package test01;

import java.util.Arrays;

import bean.Book;
import bean.ReferenceBook;
import bean.TextBook;
import common.BookStatus;
import common.BookTest;

public class Ex05BookApp {
	
	public static void main(String[] args) {
		Book[] books = mockData();
		generate("1. Khởi tạo dữ liệu sách", books);
		
		generate(
			"2. Tìm toàn bộ sách thuộc nhà xuất bản Nhi Đồng",
			filter(books, book -> {
				return "Nhi Đồng".equals(book.getPublisher());
			})
		);
		
		generate(
			"3. Tìm toàn bộ sách có đơn giá nhỏ hơn 50",
			filter(books, book -> {
				return book.getSalesPrice() < 50d;
			})
		);
		
		generate(
			"4. Tìm toàn bộ sách giá khoa có đơn giá từ 100 đến 200",
			filter(books, book -> {
				if (!(book instanceof TextBook)) {
					return false;
				}
				double salesPrice = book.getSalesPrice();
				return salesPrice >= 100d && salesPrice <= 200;
			})
		);
		
		Book[] salesBooks = {books[0], books[2], books[3], books[4], books[8]};
		generate("5. Dánh sách cần tính tiền", salesBooks);
		System.out.println("5. Tổng tiền = " +  billing(salesBooks));
	}
	
	private static double billing(Book[] salesBooks) {
		double total = 0d;
		for (Book book: salesBooks) {
			double salesPrice = book.calculateSalesPrice();
			total += salesPrice;
			System.out.println(">> " + book.getId() + " has salesPrice = " + salesPrice);
		}
		return total;
	}
	
	private static Book[] filter(Book[] books, BookTest bookTest) {
		Book[] result = new Book[books.length];
		int i = 0;
		for (Book book: books) {
			if (bookTest.isMatch(book)) {
				result[i++] = book;
			}
		}
		return Arrays.copyOfRange(result, 0, i);
	}
	
	private static Book[] mockData() {
		return new Book[] {
			new TextBook("SGK-T1", 177d, "Nhi Đồng", BookStatus.NEW),
			new TextBook("SGK-V1", 28d, "Trống Đồng", BookStatus.NEW),
			new ReferenceBook("STK-X1", 123d, "Hà Nội", 4d),
			new ReferenceBook("STK-X2", 220d, "Nhi Đồng", 6d),
			new TextBook("SGK-S1", 62d, "Quốc Gia", BookStatus.OLD),
			new TextBook("SGK-Đ1", 77d, "Nhi Đồng", BookStatus.NEW),
			new ReferenceBook("STK-X3", 188d, "Nhi Đồng", 10d),
			new ReferenceBook("STK-X4", 521d, "Quốc Gia", 8d),
			new TextBook("SGK-H1", 15d, "Trăng Non", BookStatus.OLD)
			
		};
	}
	
	private static void generate(String message, Book[] books) {
		System.out.println(message + " {");
		for (Book book: books) {
			System.out.println("    - " + book);
		}
		System.out.println("}");
	}
	
}
