package view;

import bean.car;

public class Ex01BasicOopDemo {
	public static void main(String[] args) {
		System.out.println("--------------");
		car c1 = new car(1,"Yamaha","vf2",220d,3);
		car c2 = new car(2,"ford","hrv",620d,4);
		car c3 = new car(3,"toyota","abc",219d,5);
		
		System.out.println("Xe 1:"+c1);
		System.out.println("Xe 2:"+c2);
		System.out.println("Xe 3:"+c3);
		
		System.out.println("--Ket thuc chuong trinh--");
	}
	
}
