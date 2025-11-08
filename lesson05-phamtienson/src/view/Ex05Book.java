package view;
import bean.Book;
import bean.Customer;
import bean.ReferBook;
import bean.TextBook;

public class Ex05Book {
	public static void main(String[] args) {
		Book t1 = new TextBook (01, 30d, "KimDong",1 );
		Book t2 = new TextBook (02, 40d, "NhiDong",2 );
		Book t3 = new TextBook (03, 50d, "KimDong",1 );
		
		Book r1 = new ReferBook (04, 60d, "Tre", 0.01 );
		Book r2 = new ReferBook (05, 70d, "GiaoDuc", 0.01 );
		
		Book[] b = new Book[] {t1,t2,t3,r1,r2};
		
	}

}
