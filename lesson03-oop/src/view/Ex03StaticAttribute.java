package view;

import bean.CarAdvance;

public class Ex03StaticAttribute {
	public static void main(String[] args) {
		// tao 100 mau xe Audi voi cac mau sac khac nhau
		CarAdvance.setModel("MG");
		
		CarAdvance c1 = new CarAdvance("Red");
		CarAdvance c2 = new CarAdvance("Green");
		CarAdvance c3 = new CarAdvance("Blue");
		CarAdvance c4 = new CarAdvance("Orange");
		CarAdvance c5 = new CarAdvance("Purple");
		CarAdvance ck = new CarAdvance("White");
		//...
		CarAdvance c99 = new CarAdvance("Black");
		CarAdvance c100 = new CarAdvance("Pink");
		
		// Chu so huu doi ten hang xe. Khong phai Audi ma sang ten khac MG
		
		// Neu model la nonstatic thi moi doi tuong se quan ly rieng thuoc tinh cua doi tuong do
		//
		
		//c2.setModel("MG"); // de nham lan, khong nen dung cach nay
		
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