package view;

import bean.Book;
import bean.ReferBook;
import bean.TextBook;

public class Ex05BookManagement {

	public static void main(String[] args) {
		TextBook tb1 = new TextBook("SGK001", 300000.00, "Nhi Đồng", true);
		TextBook tb2 = new TextBook("SGK002", 250000.00, "Trẻ", false);
		ReferBook rb1  = new ReferBook("STK001", 100000.00, "Nhi Đồng", 0.05);
		ReferBook rb2  = new ReferBook("STK002", 45000.00, "Trẻ", 0.01);
		Book[] books = new Book[] {
				tb1,tb2,rb1,rb2
		};
		
		System.out.println("Toàn bộ sách thuộc nhà xuất bản Nhi Đồng");
		Book[] nhiDongBooks = findBooksByPublisher(books, "Nhi Đồng");
		for(Book book : nhiDongBooks) {
			System.out.println(book);
		}
		System.out.println("====================================");
		
		System.out.println("Toàn bộ sách có đơn giá nhỏ hơn 50");
		Book[] bookHasPriceLessThan50 = findBookHasPriceLessThan50(books);
		for(Book book : bookHasPriceLessThan50) {
			System.out.println(book);
		}
		System.out.println("====================================");
		
		System.out.println("Toàn bộ sách giáo khoa có đơn giá từ 100 đến 200");
		Book[] bookHasPriceFrom100To200 = findBookHasPriceFrom100To200(books);
		for(Book book : bookHasPriceFrom100To200) {
			System.out.println(book);
		}
		System.out.println("====================================");
		
		System.out.println("Tổng tiền mà khách hàng phải thanh toán --> " 
				+ calcMoneyOfBooks(books));
		System.out.println("====================================");
	}
	
	private static Book[] findBooksByPublisher(Book[] books, String publisher) {
		Book[] result = new Book[books.length];
		int index = 0;
		for(Book book : books) {
			if(book.getPublisher().equals(publisher)) {
				result[index] = book;
				index++;
			}
		}
		return result;
 	}
	
	private static Book[] findBookHasPriceLessThan50(Book[] books) {
		Book[] result = new Book[books.length];
		int index = 0;
		for(Book book : books) {
			if(book.getPriceOfUnit() <= 50000.00) {
				result[index] = book;
				index++;
			}
		}
		return result;
	}
	
	private static Book[] findBookHasPriceFrom100To200(Book[] books) {
		Book[] result = new Book[books.length];
		int index = 0;
		for(Book book : books) {
			if(book.getPriceOfUnit() >= 100000.00 && book.getPriceOfUnit() <= 200000.00) {
				result[index] = book;
				index++;
			}
		}
		return result;
	}
	
	private static double calcMoneyOfBooks(Book[] books) {
		double result = 0;
		for(Book book : books) {
			if(book instanceof TextBook) {
				if(((TextBook) book).getIsNew() == true) {
					result += book.getPriceOfUnit();
				} else {
					result = result + 0.3*book.getPriceOfUnit();
				}
			} else {
				ReferBook rb = (ReferBook)book;
				result = result + rb.getPriceOfUnit() * (1 + rb.getTax()*100);
			}
		}
		
		return result;
	}
	
}
