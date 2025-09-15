package view;

import java.time.LocalDate;

import bean.CustomText;
import datastructure.object.CustomInt;

public class Ex03Import {
	public static void main(String[] args) {
		Integer a = 5;
		LocalDate date = LocalDate.now();
		 CustomInt cil = new  CustomInt(10);
		// dùng CustomText chỗ bean và datastructure.object
		CustomText ct1 = new CustomText ("welcome") ;
		CustomText ct2 = new CustomText( "welcome");
		System.out.println("a: " + 1);
		System.out.println("date: " + date);
		System.out.println("ci1: " + ct1);
		System.out.println("ct1: " + ct1);
		System.out.println("ct2: " + ct2) ;
	}
	
}
