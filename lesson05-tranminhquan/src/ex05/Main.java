package ex05;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Book> dsSach = new ArrayList<Book>();

		// SGK
		dsSach.add(new TextBook("SGK1", 100, "Nhi Đồng", "cũ"));
		dsSach.add(new TextBook("SGK2", 80, "Giáo Dục", "cũ"));
		dsSach.add(new TextBook("SGK3", 120, "Nhi Đồng", "cũ"));

		// STK
		dsSach.add(new ReferenceBook("STK1", 30, "Nhi Đồng", 1.2));
		dsSach.add(new ReferenceBook("STK2", 80, "Giáo Dục", 2.4));
		dsSach.add(new ReferenceBook("STK3", 40, "Nhi Đồng", 1.5));

		//Hàm tìm sách NXB NHi Đồng 
		System.out.println("Sách của NXB Nhi Đồng: ");
		for (Book s : dsSach) {
			if (s.getNhaXuatBan().equalsIgnoreCase("Nhi Đồng"))
				System.out.println(s);
		}
		
		//Hàm tìm sách có giá < 50
		System.out.println("Sách có giá < 50 : ");
		for (Book s : dsSach) {
			if (s.getDonGia() < 50)
				System.out.println(s);
		}
		
		//Hàm tìm SGK có đơn giá từ 100 - 200
		System.out.println("SGK có đơn giá từ 100 - 200 : ");
		for (Book s : dsSach) {
			if (s instanceof TextBook && s.getDonGia()>100 && s.getDonGia()<200)
				System.out.println(s);
		}
		
		//Hàm khách hàng mua
		Customer kh = new Customer("KH1", "Trần Minh Quân", "0702310702", "Quảng Nam");
		int x = 2;
		int y = 1;
		
		double tongTien = 0;
		int slText = 0;
		int slRef = 0;
		for (Book s : dsSach) {
			if (s instanceof TextBook && slText < x) {
				tongTien += s.tinhTien();
			} else if (s instanceof ReferenceBook && slRef < y) {
				tongTien += s.tinhTien();
			}
		}
		System.out.println("Khách hàng: " + kh);
		System.out.println("Tổng tiền: " + tongTien);
	}
}
