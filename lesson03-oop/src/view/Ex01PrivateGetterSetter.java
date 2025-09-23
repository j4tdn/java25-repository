package view;

import bean.Car;

public class Ex01PrivateGetterSetter {

	public static void main(String[] args) {
		
		System.out.println("---- Bắt đầu chương trình ----");
		Car c1 = new Car(1,"vinfast","vF3",220d);
		Car c2 = new Car(2,"honda","hrv",730d);
		Car c3 = new Car(3,"ford","territory",820d);
		
		c2.setAmount(6);
		c2.setSalesPrice(980d);
		
		System.out.println("c1: "+c1);
		System.out.println("c2: "+c2);
		System.out.println("c3: "+c3);
		
		System.out.println("---- Kết thúc chương trình ----");
	}
	
}
