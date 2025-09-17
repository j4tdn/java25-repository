package view;

import bean.CarAdv;

public class Ex03StaticAttribute {

	public static void main(String[] args) {
		
		CarAdv.setModel("Audi");
		CarAdv c1 = new CarAdv("Red");
		CarAdv c2 = new CarAdv("Green");
		CarAdv c3 = new CarAdv("Blue");
		CarAdv c4 = new CarAdv("Orange");
		CarAdv c5 = new CarAdv("Purple");
		CarAdv c6 = new CarAdv("White");
		CarAdv c7 = new CarAdv("Black");
		CarAdv c8 = new CarAdv("Pink");
		
		CarAdv.setModel("MG");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(c7);
		System.out.println(c8);
		
	}
	
}
