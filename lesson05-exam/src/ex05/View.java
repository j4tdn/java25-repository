package ex05;

public class View {

	public static void main(String[] args) {

		TextBook  t1 = new TextBook ("SGK001",20,"NHI ĐỒNG"," NEW");
		TextBook  t2 = new TextBook ("SGK002",30,"NHI ĐỒNG"," NEW");
		TextBook  t3 = new TextBook ("SGK003",120," FAHASHA"," NEW");
		
		ReferenceBook r1 = new ReferenceBook("STK0001", 20,"NHI ĐỒNG",1.2);
		ReferenceBook r2 = new ReferenceBook("STK0002", 80,"FAHASHA",1.3);
		
		Book[] list = {t1,t2,t3,r1,r2};
		
		System.out.println("Các sách của Nhi Đồng:");
		findProducer(list,"NHI ĐỒNG");
		System.out.println("\nCác sách có giá nhỏ hơn 50:");
		findPrice(list,50);
		System.out.println("\nCác sách có giá lớn hơn 200 và nhỏ hơn 100:");
		find(list,100000,200000);
	}
	
	private static void findProducer(Book[] books, String producer) {
		for(Book b : books) {
			if(b.getProducer().equals(producer)) {
				System.out.println(b);
			}
		}
	}
	
	private static void findPrice(Book[] books, double price) {
		for(Book b : books) {
			if(b.getPrice()<50) {
				System.out.println(b);
			}
		}
	}
	
	
	
	private static void find(Book[] books, double min, double max) {
		for(Book b : books) {
			if(b.getPrice()<max && b.getPrice()>min) {
				System.out.println(b);
			}
		}
	}
	
//	private static double totalprice(Book[] books) {
//		double total = 0;
//		for(Book b : books) {
//			if(b instanceof TextBook) {
//			}
//		}
//		
//		
//		
//	}
	
	
	

}
