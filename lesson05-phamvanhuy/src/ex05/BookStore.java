package ex05;

public class BookStore {
	public static void main(String[] args) {
		Book[] book = {
				new TextBook("SGK1", 120, "Nhi Đồng", "mới"),
				new TextBook("SGK2", 150, "Giáo Dục", "cũ"),
				new TextBook("SGK3", 80, "Xã Hội", "cũ"),
				new ReferenceBook("Stk1", 60, "Nhi Đồng", 0.1),
				new ReferenceBook("Stk2", 50, "Nhi Đồng", 0.05),
				
		};
		System.out.println("Sách nhà xuất bản Nhi Đồng: ");
		for(Book b : book) {
			if(b.getPublisher().equalsIgnoreCase("Nhi Đồng")) {
				System.out.println(b);
			}
		}
		System.out.println("Sách có đơn giá nhỏ hơn 50: ");
		for(Book b : book) {
			if(b.getPrice() < 50) {
				System.out.println(b);
			}
		}
		System.out.println("Sách giáo khoa có giá từ 100 đến 200: ");
		for(Book b : book) {
			if(b instanceof TextBook && b.getPrice() >= 100 && b.getPrice() <= 200) {
				System.out.println(b);
			}
		}
	}
}
