package view;

import bean.CarAdv;

public class Ex03StaticAttribute {
	public static void main(String[] args) {
		
		CarAdv c1 = new CarAdv( "RED");
		CarAdv c2 = new CarAdv("Green");
		CarAdv c3 = new CarAdv("Blue");
		CarAdv c4 = new CarAdv("Orange");
		CarAdv c5 = new CarAdv( "purple");
		CarAdv ck = new CarAdv("white");
		// ....
		CarAdv c99 = new CarAdv("Black");
		CarAdv c100 = new CarAdv("pink");
		
		
		// nếu model là non-static thì mỗi đối tượng sẽ quản lý riêng cái thuộc tính của đối tượng đó
		// đổi model của c2 thì chỉ ô nhớ của c2 bị thay dổi, còn lại vẫn giữ nguyên
		 CarAdv.setModel("MGN");
		
		System.out.println("c1 :" + c1);
		System.out.println("c2 :" + c2);
		System.out.println("c3 :" + c3);
		System.out.println("c4 :" + c4);
		System.out.println("c5 :" + c5);
		System.out.println("ck :" + ck);
		System.out.println("c99 :" + c99);
		System.out.println("c100 :" + c100);
		
		
		
	}

}
