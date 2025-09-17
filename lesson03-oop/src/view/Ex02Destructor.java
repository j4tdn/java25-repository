package view;

import bean.Car;

public class Ex02Destructor {

	public static void main(String[] args) {
		
		System.out.println("==== Bắt đầu chương trình ====\n");
		
		Car c1 = new Car(1, "vinfast", "vf3", 220d);
		Car c2 = new Car(2, "honda", "hrv", 880d);
		Car c3 = new Car(3, "ford", "teritory", 820d);
		
		c1 = c2;
		c3 = c1;
		
		System.out.println("c1: " + c1);
		System.out.println("c2: " + c2);
		System.out.println("c3: " + c3);
		
		System.out.println("\n==== Bắt đầu chương trình ====\n");
		
	}
	
}
