package view;

import java.time.Year;
import java.util.Scanner;

public class Ex01AgeYearTryCatch {
	
	// Dat van de
	// Bai toan: Nhap vao nam sinh cua nguoi dung, in ra so tuoi cua nguoi do
	//         : Tuoi = Nam hien tai + Nam sinh + 1
	
	public static void main(String[] args) {
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhap nam sinh:");
		
		// Cach 2: Su dung try/catch dde xu ly ngoai le(xay ra)
		
		// Dat doan ma co kha nang xay ra ngoai le trong khoi try
		// TH1: neu codde k xay ra ngoai le --> k nhay vao khoi catch --> tiep tuc ctrinh ben duoi
		// TH2: neu code xay ra ngoai le
//				2.1 bat dung ngoai le(exception, dung exception cha cua no) --> nhay vao khoi catch --> tiep ctrinh duoi
//				2.2 bat k dung ngoai le --> dung ctrinh
		
		// Han che dung catch(Exception e)
		// - k ro rang
		// - phan xu ly ben trong catch co the khac voi exception mong muon
		// - truong hop code trong khoi try co the bi nhieu exception
		// 		+ neu xu ly rieng cho tung loai --> co nhieu khoi catch xu ly rieng
		//		+ muon xu ly chung cho tat ca cac loai exception --> chi can catch(Exception) va xu ly
		
		int yob = 0;
		
		do {
			try {
				yob = Integer.parseInt(ip.nextLine());
				break;
			} catch (IllegalArgumentException e) {
//				System.out.println(">> " + nfe.getMessage());
				e.printStackTrace();
				System.out.println("k hop le nhap lai");
			}
		} while (true);	
		
		int age = Year.now().getValue() - yob + 1;
		
		System.out.println("\n==> So tuoi = " + age);
		
		ip.close();
	}
	
}

