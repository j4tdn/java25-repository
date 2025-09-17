package view;

import bean.CarAdv;

public class Ex03StaicAttribute {
	public static void main(String[] args) {
		CarAdv.setModel("Audi");
		
		CarAdv c1 = new CarAdv( "Red");
		CarAdv c2 = new CarAdv( "Green");
		CarAdv c3 = new CarAdv( "Blue");
		CarAdv c4 = new CarAdv( "Orange");
		CarAdv c5 = new CarAdv( "Purple");
		CarAdv ck = new CarAdv( "White");
		CarAdv c99 = new CarAdv( "Black");
		CarAdv c100 = new CarAdv( "Pink");
		
		
		
		System.out.println("c1: " + c1);
		System.out.println("c2: " + c2);
		System.out.println("c3: " + c3);
		System.out.println("c4: " + c4);
		System.out.println("c5: " + c5);
		System.out.println("ck: " + ck);
		System.out.println("c99: " + c99);
		System.out.println("c100: " + c100);
	
		
		
	}
}
