package view;

import java.time.LocalDate;

import bean.CustomInt;

public class Ex03Import {

	public static void main(String[] args) {
		
		/*
		
		Khi nào sẽ import
		
		- Sử dụng 1 số class của JAVA
		- Sử dụng class bên ngoài package hiện tại
		- Dùng 2 class trùng tên ở 2 package khác nhau, 1 bên import package 1 bên
		điền tên package vào chỗ code
		
		 */
		
		Integer a = 5;
		LocalDate date = LocalDate.now();
		
		bean.CustomInt ci1 = new CustomInt(10);
		
	}
	
}
