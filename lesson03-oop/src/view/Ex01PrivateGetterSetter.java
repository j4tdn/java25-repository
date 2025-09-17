package view;

import bean.Car;

public class Ex01PrivateGetterSetter {
	
	public static void main(String[] args) {
		
		System.out.println("====Bat dau chuong trinh===");
		Car c1 = new Car(1, "vinfast", "vf3", 220d);
		Car c2 = new Car(2, "honda", "hrv", 880d);
		Car c3 = new Car(3, "ford", "teritoty", 820d);
		
		//c2.amount = 1;
		//c2.salesPrice = 990d;
		
		System.out.println("c1: " + c1 );
		System.out.println("c2: " + c2 );
		System.out.println("c3: " + c3 );
		
		System.out.println("====Ket thuc chuong trinh====");
		
	}

}
