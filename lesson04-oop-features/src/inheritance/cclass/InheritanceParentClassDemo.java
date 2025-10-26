package inheritance.cclass;

import java.math.BigDecimal;

public class InheritanceParentClassDemo {
	public static void main(String[] args) {
		Book[] books = mockData();

		for (Book book : books) {
			if (book instanceof TextBook tbook) {
				if (tbook.isOld() && tbook.getDiscountInPercent().doubleValue() > 2d) {
					System.out.println(tbook);

				}
			} else if (book instanceof ReferenceBook rbook) {
				if (rbook.getTax().doubleValue() > 3d) {
					System.out.println(rbook);
				}
			}

		}
	}

	private static Book[] mockData() {
		return new Book[] { new TextBook("SGK-1", "Toan", bd("220"), Status.NEW, BigDecimal.ZERO),
				new TextBook("SGK-2", "Lich su", bd("180"), Status.OLD, bd("1")),
				new TextBook("SGK-3", "Khoa hoc tu nhien", bd("520"), Status.OLD, bd("5")),
				new TextBook("SGK-4", "My thuat", bd("82"), Status.NEW, BigDecimal.ZERO),

				new ReferenceBook("STK-1", "Vat ly", bd("440"), bd("4")),
				new ReferenceBook("STK-2", "Sinh hoc", bd("510"), bd("1")),
				new ReferenceBook("STK-3", "Hoa hoc", bd("480"), bd("6")), };

	}

	private static BigDecimal bd(String value) {
		return new BigDecimal(value);
	}

}
