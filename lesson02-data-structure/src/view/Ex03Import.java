package view;

import java.time.LocalDate;

import bean.CustomText;

public class Ex03Import {
	public static void main(String[] args) {
		/*
		 khi nao se import
		 - Su dung 1 so class cua Java
		 - Su dung cac class ben ngoai package hien tai
		 - Su dung 2 class trung ten o 2 package khac nhau, 1 ben import package, 1 ben dien package vao cho code
		 */
		Integer a = 5;
		LocalDate date = LocalDate.now();
		
		// Dung CustomText cho bean va datastructure.object
		CustomText ct1 = new CustomText("Welcome");
		
		datastructure.object.CustomText ct2 = new datastructure.object.CustomText(7, "Welcome");
		
		System.out.println("a: " + 1);
		System.out.println("date: " + date);
		System.out.println("ct1: " + ct1);
		System.out.println("ct2: " + ct2);
	}
}
