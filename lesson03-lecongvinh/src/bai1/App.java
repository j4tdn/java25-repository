package bai1;

import java.time.LocalDateTime;

public class App {
	public static void main(String[] args) {
		
	
	Customer c1 = new Customer("KH1","Adam","123","NewYork");
	Customer c2 = new Customer("KH2","Eva","235","Paris");
	
	Item i1 = new Item("SS10+","Androi","Black",620);
	Item i2 = new Item("SS20U","Androi","Green",450);
	Item i3 = new Item("IP4","IOS","White",500);
	Item i4 = new Item("IP12","IOS","Brown",780);
	Item i5 = new Item("WP8","WindowPhone","Blue",540);
	
	// Total 6210
	Order o1 = new Order(c1, new ItemDetail[] {
			new ItemDetail(i1,3), //1860
			new ItemDetail(i4,5), // 3900
			new ItemDetail(i2,1), //450 
	}, LocalDateTime.of(2025, 9, 26, 8, 0, 0));
	
	// Total 14410
	Order o2 = new Order(c2, new ItemDetail[] {
			new ItemDetail(i5,10), // 5400
			new ItemDetail(i2,9), // 4050
			new ItemDetail(i1,8), //4960
	}, LocalDateTime.of(2025, 4, 23, 9, 25, 0));
	// Total 5750
	Order o3 = new Order(c2, new ItemDetail[] {
			new ItemDetail(i2,5), //2250
			new ItemDetail(i3,7), //3500
			
	}, LocalDateTime.of(2025, 11, 14, 15, 0, 0));
	
	System.out.println(" Order 1: "+ o1.export());
	System.out.println(" Order 2: "+ o2.export());
	System.out.println(" Order 3: "+ o3.export());
	
	}
	// Write method export in Order class: non-parameter
	// Write method export in Another class: export(order)
	
}
