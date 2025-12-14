package view;

import java.util.Scanner;

public class Ex04TryMutipleCatches {
	
	// Bai toan:
	// Nhap vao tu/ mau so. Thuc hien phep chia lay phan nguyen
	
	// Khi co nhieu khoi catch
	// - neu cac loai exception k co quan he cha con --> dadt truoc/sau thoai mai
	// - neu cac loai exception co quan he cha con
	//		+ dat exception con truoc exception cha neu xu ly rieng
	//		+ xoa lun exception con neu muon xu ly exception chung
	
	// Gop chung block, loai exception khi chung logic xu ly ben trong khoi catch
	// Khac xu ly ben khoi catch --> tach catch block
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		try {

			System.out.println("Nhap vao tu so");
			int numberator = Integer.parseInt(ip.nextLine());
			
			System.out.println("Nhap vao mau so");
			int denominator = Integer.parseInt(ip.nextLine());
			
			int result = numberator/denominator;
			
			System.out.println("\n===> Ket qua: " + result);
			
		} catch (NumberFormatException nfe) {
			System.out.println(">> nfe " + nfe.getMessage());
			
		} catch (ArithmeticException ae) {
			System.out.println(">> ae " +ae.getMessage());
		}
		
		ip.close();
	}

}
