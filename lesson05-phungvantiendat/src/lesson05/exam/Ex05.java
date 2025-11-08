package lesson05.exam;

import lesson05.exam.bean.ReferBook;
import lesson05.exam.bean.Status;
import lesson05.exam.bean.TextBook;
import lesson05.exam.bean.Book;
import lesson05.exam.bean.BookBill;
import lesson05.exam.bean.BookOperation;

public class Ex05 {
	
	public static void main(String[] args) {
		Book[] books = mockData();
		System.out.println("Nhi Dong Publish");
		listBooksWithCondition(books, (book)-> book.isNhiDongPublish());

		System.out.println();

		System.out.println("Price < 50");
		listBooksWithCondition(books, (book)-> book.isPriceLessThan50());

		System.out.println();
		
		
		System.out.println("Price in [100,200] ");
		listBooksWithCondition(books, (book) -> {
			if(book instanceof TextBook t) {
				return t.isPriceOfBookFrom100To200();
			}
			return false;
		});

		// price of TextBook
		System.out.println(getTotalBillOfEachBook(books, (arr) -> {
			double sum = 0;
			for(Book book : arr) {
				if(book instanceof TextBook) {
					sum+=((TextBook) book).getTotalPrice();
				}
			}
			return sum;
		}));

		// price of ReferBook
		System.out.println(getTotalBillOfEachBook(books, (arr) -> {
			double sum = 0;
			for(Book book : arr) {
				if(book instanceof ReferBook) {
					sum+=((ReferBook) book).getTotalPrice();
				}
			}
			return sum;
		}));
	}
	
	private static Book[] mockData() {
		Book[] books = new Book[] {
				new TextBook(1, 50, "Nhi Đồng", Status.NEW),
				new TextBook(2, 80, "Kim Đồng", Status.OLD),
				new TextBook(3, 200, "Nhà xuất bản trẻ", Status.NEW),
				new TextBook(4, 130, "Nhi Đồng", Status.NEW),
				new TextBook(5, 180, "Thanh niên", Status.OLD),
				new ReferBook(6, 280, "Nhi Đồng", 0.2),
				new ReferBook(7, 350, "Thanh niên", 0.15),
				new ReferBook(8, 320, "Kim Đồng", 0.3),
				new ReferBook(9, 400, "Nhi Đồng", 0.25),
				new ReferBook(10, 500, "Nhà xuất bản trẻ", 0.1),
		};
		return books;
	}
	
	private static void listBooksWithCondition(Book[] books, BookOperation bookOperation) {
		for(Book item : books) {
			if(bookOperation.test(item)) {
				System.out.println(item);
			}
		}
	}
	
	private static double getTotalBillOfEachBook(Book[] books, BookBill bookBill) {
		return bookBill.getTotalBill(books);
	}
	
//	private static void listBooksHasPriceFrom100To200(Book[] books) {
//		for(Book item : books) {
//			if(item instanceof TextBook t && t.isPriceOfBookFrom100To200()) {
//				System.out.println(item);
//			}
//		}
	
}
