package view;

import java.time.LocalDate;

import bean.CustomInt;
import bean.CustomText;

public class Ex03Import {

	public static void main(String[] args) {
		
		/*
		 * Khi nào sẽ import
		 * - Sử dụng 1 số class của Java
		 * - 
		 * 
		 */
		 Integer a=5;
		 LocalDate date= LocalDate.now();
		 CustomInt ci1 =new CustomInt(10);
		 CustomText ct1 = new CustomText("welcome");
		 datastructure.object.CustomText ct2 = new datastructure.object.CustomText(7, "welcome");
		 
		 System.out.println("a: "+1);
		 System.out.println("date: "+date);
		 System.out.println("ci1: "+ci1);
		 System.out.println("ct1: "+ct1);
		 System.out.println("ct2: "+ct2);
	}
	
}
