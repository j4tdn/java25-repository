package utils;

import bean.Book;
import bean.Textbook;

public class Search {
	
	/*
		 ▪ Viết hàm thực hiện lần lượt các chức năng sau đây:
			▪ Tìm toàn bộ sách thuộc nhà xuất bản Nhi Đồng
			▪ Tìm toàn bộ sách có đơn giá nhỏ hơn 50
			▪ Tìm toàn bộ sách giáo khoa có đơn giá từ 100 đến 200
			
	 */
	public Search() {
	}
	
	public static void searchPulisher(Book[] listBook, String puclisher) {
		boolean found = false;
		for(Book book: listBook) {
			if(book.getPublisher().equalsIgnoreCase("Nhi Dong")) {
				System.out.println(book);
				found = true;
			}
		}
		if(!found) {
			System.out.println("k tim thay sach cua " + puclisher);
		}
	}
	
	public static void searchPrice1(Book[] listBook) {
		boolean found = false;
		for(Book book: listBook) {
			if(book.getPrice() < 50) {
				System.out.println(book);
				found = true;
			}
		}
		if(!found) {
			System.out.println("k tim thay sach co on gia duoi 50");
		}
	}
	
	public static void searchPrice2(Book[] listBook) {
		boolean found = false;
		for(Book book: listBook) {
			if(book instanceof Textbook && book.getPrice() > 100 && book.getPrice() < 200) {
				System.out.println(book);
				found = true;
			}
		}
		if(!found) {
			System.out.println("k tim thay sach co on gia duoi 50");
		}
	}
}
