package Bai05;

public class Main {
	
	public static void main(String[] args) {
		Book[] books = {
				new TextBook("SGK01", "Nhi Đồng", 120, true),
				new TextBook("SGK02", "Giáo Dục", 80, false),
				new TextBook("SGK03", "Xã Hội", 150, false),
				new ReferBook("STK01", "Nhi Đồng", 60, 0.05),
				new ReferBook("STK02", "Kim Đồng", 40, 0.1),
		};
		
		System.out.println("Sách nhà suất bản Nhi Đồng: ");
		for(Book b : books) {
			if(b.getPublisher().equalsIgnoreCase("Nhi Đồng")) {
				System.out.println(b);
			}
		}
		
		System.out.println("\nSách có đơn giá nhỏ hơn 50: ");
		for(Book b : books) {
			if(b.getPrice() < 50) {
				System.out.println(b);
			}
		}
		
		System.out.println("\nSách giáo khoa giá từ 100 đến 200: ");
		for(Book b : books) {
			if(b instanceof TextBook && b.getPrice() >= 100 && b.getPrice() <= 200) {
				System.out.println(b);
			}
		}
		
		double Total = books[0].Total() + books[3].Total();
		System.out.println("Tổng số tiền khi mua 1 cuốn SGK và 1 cuốn STK là: " + Total);
	}
}
