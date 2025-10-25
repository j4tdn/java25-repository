package inheritance.cclass;

import java.math.BigDecimal;

import polymorphism.object.Square;

public class InheritanceParentClassDemo {
	
	/*
	 Quan ly van phong pham
	 
	 SGK: ID, name, price, tinh trang(cu, moi), phan tram giam gia
	 Sach tham khao: ID, name, price, thue xuat ban
	 
	 Yeu cau:
	 1. Tao N doi tuong SGK, STK
	 2. Tim nhung cuon sach la SGK cu co % giamr gia > 2% va STK co thue > 3%
	 
	 Book: id, name, salePrices
	 
	 TextBook extends Book
	 --> status,discountInPercent
	 
	 ReferenceBook extends Book
	 --> tax
	 */
	
	public static void main(String[] args) {
		Book[] books = mockDate();
		for(Book book: books) {
			if(book instanceof TextBook tbook) {
				if(tbook.getStatus() == Status.OLD && tbook.getDiscountInPercent().doubleValue() > 2d) {
					System.out.println(tbook);
				}
			}
			else if(book instanceof ReferenceBook rbook) {
				if(rbook.getTax().doubleValue() > 3d) {
					System.out.println(rbook);
				}
			}
		}
		
	}
	
	private static Book[] mockDate() {
		return new Book[] {
			new TextBook("SGK-1", "Toan", bd("220"), Status.NEW, BigDecimal.ZERO),
			new TextBook("SGK-2", "Su", bd("180"), Status.OLD, bd("1")),
			new TextBook("SGK-3", "KHTN", bd("520"), Status.OLD, bd("5")),
			new TextBook("SGK-4", "My thua", bd("82"), Status.NEW, BigDecimal.ZERO),
			
			new ReferenceBook("STK-1", "Vat ly TK", bd("440"), bd("4")),
			new ReferenceBook("STK-2", "Sinh hoc TK", bd("510"), bd("1")),
			new ReferenceBook("STK-3", "Hoa hoc TK", bd("480"), bd("6")),
		};
	}
	
	private static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}
	
}
