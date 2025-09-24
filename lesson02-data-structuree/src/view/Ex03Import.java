package view;

import java.time.LocalDate;

import bean.CustomText;

public class Ex03Import {
	
	public static void main(String[] args) {
		/*
		 Khi nào sẽ import
		 - Sử dụng một số class của Java
		 - Sử dụng class bên ngoài package hiện tại
		 - Dùng 2 class trùng tên ở 2 package khác nhau, 1 bên import package 1 bên điền tên package vào
		   chỗ code
		 */
		
		Integer a = 5;
		LocalDate date = LocalDate.now();
		
		bean.CustomInt ci1 = new bean.CustomInt(10);
		
		// dùng CustomText chỗ bean và datastructure.object
		CustomText ct1 = new CustomText("welcome");
		datastructure.object.CustomText ct2 = new datastructure.object.CustomText(7, "welcome");
		
		System.out.println("a: " + 1);
		System.out.println("date: " + date);
		System.out.println("ci1: " + ci1);
		System.out.println("ct1: " + ct1);
		System.out.println("ct2: " + ct2);
	}
	
}