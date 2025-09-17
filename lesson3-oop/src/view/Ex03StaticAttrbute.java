package view;

import bean.CarAdv;

public class Ex03StaticAttrbute {
	public static void main(String[] args) {
		CarAdv c1 = new CarAdv("Red");
		CarAdv c2 = new CarAdv("Yellow");
		CarAdv c3 = new CarAdv("Orange");
		CarAdv c4 = new CarAdv("Green");
		CarAdv c5 = new CarAdv("Blue");
		CarAdv ck = new CarAdv("Purple");
		CarAdv c99 = new CarAdv("White");
		CarAdv c100 = new CarAdv("Gray");

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
