package view;

import bean.CarAdv;

public class Ex03StaticAttribute {
	
	public static void main(String[] args) {
		
		CarAdv c1 = new CarAdv("Red");
		CarAdv c2 = new CarAdv("Green");
		CarAdv c3 = new CarAdv("White");
		CarAdv c4 = new CarAdv("Yellow");
		CarAdv c5 = new CarAdv("Orange");
		CarAdv ck = new CarAdv("Blue");
		CarAdv c99 = new CarAdv("Black");
		CarAdv c100 = new CarAdv("Silver");
		
		// chủ sở hữu muốn đổi tên hãng xe. không phải Audi mà sang tên khác MG
		// đổi model của c2 thì chỉ ô nhớ của c2 bị thay đổi, còn lại vẫn giữ nguyên
		
		CarAdv.setModel("MG");
		
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
