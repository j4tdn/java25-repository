package view;

import java.time.LocalDate;

import bean.CustomText;

public class EX03Import {
	public static void main(String[] args) {
		
		/*
		  khi nào sẽ import
		  - sử dụng một số class của java
		  - sử dụng các class bên ngoài package hiện tại
		  - dùng 2 class trùng tên ở 2 package khác nhau, 1 ben import package 1 ben điền tên package vào
		  
		  
		 */
		Integer a = 5;
		LocalDate date = LocalDate.now();
		
		
		
		// dùng CustomText chỗ bean và datastucture.object
		CustomText ct1 = new CustomText("Wellcome");
		datastructure.objectavalable.CustomText ct2 = new datastructure.objectavalable.CustomText(7, "Wellcome");
		
		System.out.println("a:" + a);
		System.out.println("date:" + date);
		System.out.println("ct1:" + ct1);
		System.out.println("ct2" + ct2);
	}

}
