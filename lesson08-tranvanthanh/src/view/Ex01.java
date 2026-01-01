package view;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		System.out.println("Nhập chuỗi kí tự: ");
		String text = ip.nextLine();
		System.out.println("==========In ra mỗi kí tự trên một dòng=============");
		for (int i = 0; i < text.length(); i++) {
			System.out.println(text.charAt(i) + " ");
		}
		System.out.println("==========In ra mỗi từ trên mỗi dòng=============");

		String[] elements = text.split(" ");
		for (String element : elements) {
			System.out.println(element);
		}
		System.out.println("============In ra chuỗi đảo ngược theo kí tự============");

		for (int i = text.length() - 1; i >= 0; i--) {
			System.out.println(text.charAt(i));
		}
		System.out.println("=============In ra chuỗi đảo ngược theo từ==============");
		for (int i = elements.length - 1; i >= 0; i--) {
			System.out.println(elements[i]);
		}
		
		ip.close();
	}

}