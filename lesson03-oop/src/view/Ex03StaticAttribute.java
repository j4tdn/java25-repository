package view;

import bean.Car;
import bean.CarAdv;

public class Ex03StaticAttribute {
	public static void main(String[] args) {
		
	
	CarAdv c1 = new CarAdv("Audi1","red");
	CarAdv c2 = new CarAdv("Audi","Green");
	CarAdv c3 = new CarAdv("Audi","Blue");
	CarAdv c4 = new CarAdv("Audi","orange");
	CarAdv c5 = new CarAdv("Audi","purple");
	CarAdv ck = new CarAdv("Audi","White");
	
	CarAdv c99 = new CarAdv("Audi","Black");
	CarAdv c100 = new CarAdv("Audi8","Pink");
	
	CarAdv.setModel("MG");
	//c2.setModel("MG");
	
	System.out.println("c1: "+c1);
	System.out.println("c1: "+c2);
	System.out.println("c1: "+c3);
	System.out.println("c1: "+c4);
	System.out.println("c1: "+c5);
	System.out.println("c1: "+ck);
	System.out.println("c1: "+c99);
	System.out.println("c1: "+c100);
	
	}	
}