package ex05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookStore {
	public static void main(String[] args) {
		List<TextBook> sgkList = Arrays.asList(
				new TextBook("SGK01",110,"Nhi Dong","moi"),
				new TextBook("SGK02",80,"Toan","Cu"),
				new TextBook("SGK03",100,"Mi thuat","Cu")
				);
		List<ReferenceBook> stkList = Arrays.asList(
				new ReferenceBook("Stk01",80,"GiaiToan",0.2),
				new ReferenceBook("Stk02",80,"Ve",0.05)
				);
		System.out.println("Sach NXB Nhi Dong");
		for(Book b : concat(sgkList,stkList)) {
			if(b.getNhaXuatBan().equalsIgnoreCase("Nhi Dong")) {
				b.toString();
			}
		}
		System.out.println("Sach co don gia <50");
		for(Book b :concat(sgkList, stkList)) {
			if(b.getDonGia()<50) {
				b.toString();
			}
		}
		System.out.println("Sach co don gia tu 100-200");
		for(TextBook t : sgkList) {
			if(t.getDonGia() >=100 &&t.getDonGia() <= 200) {
				t.toString();
			}
		}
	}

	private static List<Book> concat(List<TextBook> sgkList, List<ReferenceBook> stkList) {
		List<Book> all = new ArrayList<>();
		all.add((Book) sgkList);
		all.add((Book) stkList);
		return all;
	}
	
	
}
