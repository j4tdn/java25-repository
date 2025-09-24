package view;

import bean.CarAdv;

public class Ex03StaticAttribute {
	public static void main(String[] args) {
		CarAdv.setModel("audi");
		CarAdv c1 = new CarAdv("red");
		CarAdv c2 = new CarAdv("green");
		CarAdv c3 = new CarAdv("blue");
		CarAdv c4 = new CarAdv("orange");
		CarAdv c5 = new CarAdv("purplr");
		CarAdv ck = new CarAdv("white");
		CarAdv c99 = new CarAdv("black");
		CarAdv c100 = new CarAdv("pink");
		
//		c2.setModel("MG");
		CarAdv.setModel("mg");
		
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
