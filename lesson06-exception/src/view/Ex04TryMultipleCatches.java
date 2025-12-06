package view;

import java.util.Scanner;

public class Ex04TryMultipleCatches {
	// Bai toan
	// Nhap vao tu/mau so. Thuc hien phep chia lay phan nguyen
	
	// Khi co nhieu khoi catch
	// - Neu cac loai Exception khong co quan he cha con --> dat truoc/sau thoai mai
	// - Neu ton tai cac Exception co quan he cha con
	//   . dat exception con truoc exception cha neu xu ly rieng
	//   . xoa luon exception con neu muon xu ly exception chung

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		try {
			System.out.println("Nhap vao tu so: ");
			int numerator = Integer.parseInt(ip.nextLine());
			
			System.out.println("Nhap vao mau so: ");
			int denominator = Integer.parseInt(ip.nextLine());
			
			int result = numerator/denominator;
			
			System.out.println("\n==> ket qua: "+ result);
		} catch (ArithmeticException | IllegalArgumentException ex) {
			System.out.println(">> e "+ex.getMessage());
		} 
		
		ip.close();
	}

}
