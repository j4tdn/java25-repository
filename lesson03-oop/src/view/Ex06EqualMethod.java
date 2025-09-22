package view;

import bean.Car;

public class Ex06EqualMethod {
	public static void main(String[] args) {
		/*
		 Ly thuyet
		 Bien KDL nguyen thuy
		 - Stack: gia tri thuc te
		 
		 Bien KDL doi tuong
		 - Stack: dia chi cua o nho tai HEAP ma no dang tro den
		 - Heap: gia tri thuc te cua doi tuong
		 
		 De so sanh gia tri cua 2 bien co bang hay giong nhau k --> thuong su dung toan tu ==
		
		 Su dung toan tu == (so sanh gia tri cua bien o stack)
		 
		 Nhu vay 
		 
		 Dung toan tu == de so sanh 2 bien nguyen thuy --> so sanh gia tri --> OK
		 
		 Dung toan tu == de so sanh 2 bien doi tuong --> so sanh dia chi(so xem 2 bien nay co dang tro dedn cung dia chi hay k)
		 
		 --> Muon so sanh gia tri 2 bien doi tuong ?
		 --> Doi tuong co the co 1 hoac nhieu thuoc tinh, khi so sanh can dat cau hoi 2 doi tuong ddo ntn la bang nhau
		
		 Su dung ham equals
		 
		 	- Tu class Object, mac dinh ham equals co body cung la so sanh dia chi 2 bien doi tuong
		 	- K dung ham equals mac dinh ma override sao cho 2 bien doi tuowng do so sanh gia tri tai HEAP
		 --> Doi tuong co the co 1 hoac nhieu thuoc tinh, khi so sanh can dat cau hoi 2 doi tuong ddo ntn la bang nhau
		 --> VD: 2 doi tuong Car bang nhau khi id gionng nhau
		
		 Voi cac class co san cua Java nhu Integer, String, Double,... da thua ke override lai ham equals tu class Object roi de so sanh theo gia tri
		 */
		
		Car c1 = new Car(1, "honda", "crv", 1240d);
		Car c2 = new Car(1, "honda", "crv", 1240d);
		Car c3 = new Car(2, "honda", "crv", 1240d);
		
		System.out.println("(c1==c2): " + (c1==c2));
		System.out.println("(c1 eq c2): " + (c1.equals(c2)));
		System.out.println("(c1 eq c3): " + (c1.equals(c3)));
		
		String s1 = "Hello";
		String s2 = "Hello";
		
		System.out.println("(s1==s2): " + (s1==s2));
		
		
	}
}
