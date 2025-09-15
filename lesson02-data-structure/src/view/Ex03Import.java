package view;

import java.time.LocalDate;

import bean.CustomText;

public class Ex03Import {
	/**
	 * Khi nào Import +Sử dụng một số class của java +Sử dụng class bên ngoài
	 * package hiện tại Dùng 2 class trùng tên ở 2 package khác nhau, 1 bên import
	 * package 1 bên điền tên package vào chỗ code
	 * 
	 **/
	public static void main(String[] args) {
		Integer a = 5;
		LocalDate localdate = LocalDate.now();
		bean.CustomInt c1 = new bean.CustomInt(20);
		CustomText c2 = new CustomText("Văn Tài");
		datastructure.object.CustomText c3 = new datastructure.object.CustomText(5, "Văn Tài đẹp trai");
		System.out.println(a);
		System.out.println(localdate);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

	}
}
